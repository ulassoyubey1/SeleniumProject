package com.trendyolselenium.framework.base;

import com.trendyolselenium.framework.config.Settings;
import com.trendyolselenium.framework.utilities.logUtil;
import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver _driver;
    public BrowserType type;

    public Browser(WebDriver _driver) {
        this._driver = _driver;
    }

    public void GoToUrl(String url){
        _driver.get(url);
        logUtil.infoLog("Navigating to " + url);

    }

    public void MaximizeWindow(){
        _driver.manage().window().maximize();
    }
    public void QuitBrowserCompletely(){_driver.quit();}
}


