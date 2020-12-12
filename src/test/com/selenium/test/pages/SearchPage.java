package com.selenium.test.pages;

import com.trendyolselenium.framework.base.Base;
import com.trendyolselenium.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends BasePage {

    public SearchPage() {
        super();
    }

    @FindBy(how = How.XPATH,using = "(//img[@class='p-card-img'])[3]")
    public WebElement firstProductImg;

    public ProductPage clickFirstProduct(){
        firstProductImg.click();
        return new Base().CreatePageInstance(ProductPage.class);
    }
}
