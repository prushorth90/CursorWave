package com.cursorwave.service.llm;

import com.cursorwave.model.AgentPlan;
import org.springframework.stereotype.Service;
// logic to call your local Python/Llama endpoint
import org.springframework.web.client.RestTemplate;

@Service("llamaStrategy")
public class LlamaLocalStrategy implements LLMStrategy {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final String LLAMA_ENDPOINT = "http://localhost:8000/generate";

    @Override
    public AgentPlan generatePlan(String userCommand, String htmlContext) {
        // Construct payload for your fine-tuned model
        // This correlates to the "fine-tuned Llama 3 8B model" in your resume [cite: 21]
        var payload = new LlamaRequest(userCommand, htmlContext); 
        return restTemplate.postForObject(LLAMA_ENDPOINT, payload, AgentPlan.class);
    }
}