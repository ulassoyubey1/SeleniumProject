package com.selenium.test.pages;

import com.trendyolselenium.framework.base.BasePage;
import com.trendyolselenium.framework.base.DriverContext;
import com.trendyolselenium.framework.utilities.logUtil;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {

    @FindBy(how = How.CLASS_NAME,using = "total-price")
    public WebElement spnTotalPrice;
    @FindBy(how = How.CLASS_NAME,using = "counter-content")
    public WebElement quantityInBaset;
    @FindBy(how = How.XPATH,using = "//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")
    public WebElement   increaseQuantityBtn;
    @FindBy(how = How.XPATH,using = "//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button")
    public WebElement deleteItemsBtn;
    @FindBy(how = How.XPATH,using = "//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")
    public WebElement deleteBtnPopup;
    @FindBy(how = How.XPATH,using = "//span[text()='Sepetinizde ürün bulunmamaktadır.']")
    public WebElement spnNoItemsFoundInBasket;

    public String checkTotalPrice(){
        String totalPrice = spnTotalPrice.getAttribute("innerText");
        logUtil.infoLog("Current basket price is " + totalPrice);
         totalPrice = totalPrice.replaceAll("\\u00a0"," ");
        return totalPrice;
    }
    public void checkQuantity(int quantity){
        try{
            WebDriverWait wait = new WebDriverWait(DriverContext.Driver,15);
            wait.until(ExpectedConditions.textToBePresentInElementValue(quantityInBaset,Integer.toString(quantity)));
            logUtil.infoLog("Current items added on basket:" + quantity);
        }catch (Exception e){
            logUtil.error("Item has only one stock");
            throw e;
        }
    }
    public void IncreaseQuantity(){

        increaseQuantityBtn.click();
    }
    public void DeleteItems(){
        deleteItemsBtn.click();
        deleteBtnPopup.click();
    }
    public void CheckAllItemsDeleted(){
        WebDriverWait wait = new WebDriverWait(DriverContext.Driver,30);
        try{
            wait.until(ExpectedConditions.visibilityOf(spnNoItemsFoundInBasket));
            logUtil.infoLog("Items deleted succesfully");
        }catch (TimeoutException e) {
            logUtil.error("Items not deleted");
            throw new IllegalStateException("Element Is Not Visible");
        }
    }
}
