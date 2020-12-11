package com.selenium.test.pages;

import com.trendyolselenium.framework.base.Base;
import com.trendyolselenium.framework.base.BasePage;
import com.trendyolselenium.framework.base.DriverContext;
import com.trendyolselenium.framework.utilities.logUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(){
        super();
    }
    @FindBy(how = How.ID, using = "accountBtn")
    public WebElement lnkLogin;

    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
    public WebElement btnFirstPopUpClose;


    @FindBy(how = How.XPATH,using = "//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']")
    public WebElement searchBoxInput;

    @FindBy(how = How.CLASS_NAME,using = "search-icon")
    public WebElement searchIcon;

    @FindBy(how = How.CLASS_NAME,using = "modal-close")
    public WebElement discountModalCloseBtn;

    @FindBy(how = How.CLASS_NAME,using = "user-email")
    public WebElement loggedUser;
    public void ClosePopup(){
        JavascriptExecutor executor = (JavascriptExecutor)DriverContext.Driver;
        executor.executeScript("arguments[0].click();", btnFirstPopUpClose);

    }
    public void CloseDiscountModal(){
        discountModalCloseBtn.click();
    }
    public SearchPage SearchElement(String searchElement) throws InterruptedException {
        searchBoxInput.sendKeys(searchElement);
        Thread.sleep(1000);
        searchIcon.click();
        return new Base().CreatePageInstance(SearchPage.class);
    }
    public LoginPage clickLogin(){

        lnkLogin.click();
        return new Base().CreatePageInstance(LoginPage.class);
    }
    public void CheckUserLoggedIn(){
        Actions actions = new Actions(DriverContext.Driver);
        actions.moveToElement(lnkLogin).perform();
        WebDriverWait wait = new WebDriverWait(DriverContext.Driver,30);
        try{
            wait.until(ExpectedConditions.visibilityOf(loggedUser));
            logUtil.infoLog("Current logged user: " + loggedUser.getAttribute("innerText"));
        }catch (Exception e){
            logUtil.error("Login is not Succesfull");
            throw e;
        }
    }
}
