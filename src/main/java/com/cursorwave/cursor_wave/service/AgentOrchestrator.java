package com.cursorwave.service;

import com.cursorwave.model.AgentPlan;
import com.cursorwave.service.automation.ActionFactory;
import com.cursorwave.service.llm.LLMStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class AgentOrchestrator {

    private final LLMStrategy complexStrategy;
    private final LLMStrategy simpleStrategy;
    private final ActionFactory actionFactory;
    private WebDriver driver;

    public AgentOrchestrator(@Qualifier("gpt4Strategy") LLMStrategy complexStrategy,
                             @Qualifier("llamaStrategy") LLMStrategy simpleStrategy,
                             ActionFactory actionFactory) {
        this.complexStrategy = complexStrategy;
        this.simpleStrategy = simpleStrategy;
        this.actionFactory = actionFactory;
    }

    @PostConstruct
    public void init() {
        this.driver = new ChromeDriver(); // Initialize Selenium
    }

    public void executeCommand(String userCommand) {
        // 1. Get Context
        String currentHtml = driver.getPageSource();

        // 2. Route Strategy (Router Logic from Resume [cite: 21])
        LLMStrategy selectedStrategy = isComplexTask(userCommand) ? complexStrategy : simpleStrategy;

        // 3. Get Plan
        AgentPlan plan = selectedStrategy.generatePlan(userCommand, currentHtml);

        // 4. Execute Actions via Factory
        for (AgentPlan.ActionStep step : plan.getSteps()) {
            var action = actionFactory.getAction(step.getType());
            action.execute(driver, step.getParams());
        }
    }

    private boolean isComplexTask(String command) {
        // Simple heuristic or classifier logic
        return command.length() > 50 || command.contains("find best");
    }
}