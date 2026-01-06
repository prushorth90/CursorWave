package com.cursorwave.service.llm;

import com.cursorwave.model.AgentPlan;

public interface LLMStrategy {
    /**
     * Takes the user's command and current HTML, returns a structured plan.
     */
    AgentPlan generatePlan(String userCommand, String htmlContext);
}