package com.selenium.test.pages;

import com.trendyolselenium.framework.base.Base;
import com.trendyolselenium.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
    public LoginPage() {
        super();
    }

    @FindBy(how = How.ID, using = "login-email")
    public WebElement txtUsername;

    @FindBy(how = How.ID, using = "login-password-input")
    public WebElement  txtPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-register\"]/div[3]/div[1]/form/button")
    public WebElement btnLogin;



    public HomePage Login(String userName,String password){
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return new Base().CreatePageInstance(HomePage.class);

    }
}
