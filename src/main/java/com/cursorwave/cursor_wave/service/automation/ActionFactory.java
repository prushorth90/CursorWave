package com.cursorwave.service.automation;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ActionFactory {
    
    // Auto-wires all implementations of BrowserAction into a map
    // Key = Component Name (e.g., "NAVIGATE"), Value = Implementation
    private final Map<String, BrowserAction> actionMap;

    public ActionFactory(Map<String, BrowserAction> actionMap) {
        this.actionMap = actionMap;
    }

    public BrowserAction getAction(String actionType) {
        if (!actionMap.containsKey(actionType)) {
            throw new IllegalArgumentException("Unknown action type: " + actionType);
        }
        return actionMap.get(actionType);
    }
}