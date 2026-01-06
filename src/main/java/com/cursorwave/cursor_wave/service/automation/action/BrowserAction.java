package com.cursorwave.service.automation;

import org.openqa.selenium.WebDriver;
import java.util.Map;

public interface BrowserAction {
    void execute(WebDriver driver, Map<String, String> params);
}