package com.cursorwave.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class AgentPlan {
    private String reasoning;
    private List<ActionStep> steps;

    @Data
    public static class ActionStep {
        private String type; // e.g., "NAVIGATE", "CLICK", "TYPE"
        private Map<String, String> params; // e.g., {"url": "google.com"}
    }
}