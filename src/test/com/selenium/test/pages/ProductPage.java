package com.selenium.test.pages;

import com.trendyolselenium.framework.base.Base;
import com.trendyolselenium.framework.base.BasePage;
import com.trendyolselenium.framework.base.DriverContext;
import com.trendyolselenium.framework.utilities.logUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
    public ProductPage() {
    }
    @FindBy(how = How.CLASS_NAME,using = "add-to-bs-tx")
    public WebElement btnAddtoCart;
    @FindBy(how = How.XPATH,using = "//*[@id='product-detail-app']/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div/div/div[3]/div[2]/span")
    public WebElement spnProductPagePrice;
    @FindBy(how = How.XPATH,using = "//span[@class='prc-slg']")
    public WebElement spnPriceWithoutDiscount;
    @FindBy(how = How.ID,using = "basketItemCount")
    public WebElement spnBasketItemCount;
    @FindBy(how = How.XPATH,using = "//*[@id=\"myBasketListItem\"]/div[1]/a/i")
    public WebElement iconBasket;

    public void CheckElementAddedToBasket(){
        WebDriverWait wait = new WebDriverWait(DriverContext.Driver,40);
        wait.until(ExpectedConditions.attributeToBe(spnBasketItemCount,"innerText","1"));
    }
    public String getProductPrice(){
        String pagePrice = null;
        try{
            spnProductPagePrice.isDisplayed();
            pagePrice = spnProductPagePrice.getAttribute("innerText");
            logUtil.infoLog("There is discount on basket");
            logUtil.infoLog("Price on product page: " + pagePrice);

            return pagePrice;

        }catch (Exception e){
            pagePrice = spnPriceWithoutDiscount.getAttribute("innerText");
            logUtil.infoLog("Price on product page: " + pagePrice);
            logUtil.infoLog("Price dont have any discount on basket");
            return pagePrice;
        }
    }
    public void AddElementToBasket(){
        btnAddtoCart.click();
    }
    public BasketPage NavigateToBasket(){
        iconBasket.click();
        return new Base().CreatePageInstance(BasketPage.class);
    }
}
