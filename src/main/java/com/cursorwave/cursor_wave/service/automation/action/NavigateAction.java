package com.cursorwave.service.automation.actions;

import com.cursorwave.service.automation.BrowserAction;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component("NAVIGATE")
public class NavigateAction implements BrowserAction {
    @Override
    public void execute(WebDriver driver, Map<String, String> params) {
        String url = params.get("url");
        if (url != null) {
            driver.get(url);
        }
    }
}