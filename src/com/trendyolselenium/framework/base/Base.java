package com.trendyolselenium.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage CurrentPage;

    public<TPage extends BasePage> TPage CreatePageInstance(Class<TPage> page){
        Object obj = PageFactory.initElements(DriverContext.Driver,page);
        return page.cast(obj);
    }
}
