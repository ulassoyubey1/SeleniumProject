package com.trendyolselenium.framework.base;

public abstract class BasePage {
   /* public BasePage() {
        PageFactory.initElements(DriverContext.Driver,this);
    }*/
    public <TPage extends BasePage> TPage As(Class<TPage> pageInstance){
        try {
            return (TPage)this;
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }
}
