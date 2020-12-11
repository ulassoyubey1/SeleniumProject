package com.trendyolselenium.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameworkInitiliaizer extends Base {

    public void OpenBrowser(BrowserType type){
        WebDriver driver = null;
        switch (type){
            case Chrome :{
                System.setProperty("webdriver.chrome.driver","chromedriver.exe");
                 driver= new ChromeDriver();

            }
            case Firefox:{
                break;
            }
            case IE:
            case Safari: {
                break;
            }
        }
        DriverContext.setDriver(driver);
        DriverContext.Browser = new Browser(driver);

    }

}
