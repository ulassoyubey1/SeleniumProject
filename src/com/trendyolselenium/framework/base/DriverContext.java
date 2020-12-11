package com.trendyolselenium.framework.base;

import com.trendyolselenium.framework.config.Settings;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverContext {

    public static WebDriver Driver;
    public static Browser Browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
        Driver.manage().timeouts().implicitlyWait(Settings.ImplicitWaitTime, TimeUnit.SECONDS);
    }


}
