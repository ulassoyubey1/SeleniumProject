package com.trendyolselenium.framework.config;

import com.trendyolselenium.framework.base.BrowserType;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }
    private void ReadProperty() throws IOException {
        Properties p = new Properties();
        p.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        Settings.excelSheetPath = p.getProperty("excelSheetPath");
        Settings.firstUrl = p.getProperty("firstUrl");
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("BrowserType"));
        Settings.ImplicitWaitTime = Integer.parseInt(p.getProperty("ImplicitWaitTime"));
    }
}
