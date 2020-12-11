package com.selenium.test.seleniumtest;

import com.selenium.test.pages.*;
import com.trendyolselenium.framework.base.DriverContext;
import com.trendyolselenium.framework.base.FrameworkInitiliaizer;
import com.trendyolselenium.framework.config.ConfigReader;
import com.trendyolselenium.framework.config.Settings;
import com.trendyolselenium.framework.utilities.ExcelUtil;
import jxl.read.biff.BiffException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestiniumProjectTest extends FrameworkInitiliaizer {
    @Before
    public void Initialize() throws IOException, BiffException {
        ConfigReader.PopulateSettings();
        OpenBrowser(Settings.BrowserType);
        DriverContext.Browser.GoToUrl(Settings.firstUrl);
        DriverContext.Browser.MaximizeWindow();
        ExcelUtil util = new ExcelUtil(Settings.excelSheetPath, 0);
        util.OpenExcel();
     }

     @Test
     public void TestCase01() throws InterruptedException {
        CurrentPage = CreatePageInstance(HomePage.class);
        CurrentPage.As(HomePage.class).ClosePopup();
        CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
        CurrentPage = CurrentPage.As(LoginPage.class).Login(ExcelUtil.ReadCell("userName",1),ExcelUtil.ReadCell("password",1));
        CurrentPage.As(HomePage.class).CloseDiscountModal();
        CurrentPage.As(HomePage.class).CheckUserLoggedIn();
        CurrentPage = CurrentPage.As(HomePage.class).SearchElement("bilgisayar");
        CurrentPage = CurrentPage.As(SearchPage.class).clickFirstProduct();
        CurrentPage.As(ProductPage.class).AddElementToBasket();
        CurrentPage.As(ProductPage.class).CheckElementAddedToBasket();
        String productPrice = CurrentPage.As(ProductPage.class).getProductPrice();
        CurrentPage = CurrentPage.As(ProductPage.class).NavigateToBasket();
        String totalPrice = CurrentPage.As(BasketPage.class).checkTotalPrice();
        Assert.assertEquals(totalPrice,productPrice);
        CurrentPage.As(BasketPage.class).IncreaseQuantity();
        CurrentPage.As(BasketPage.class).checkQuantity(2);
        CurrentPage.As(BasketPage.class).DeleteItems();
        CurrentPage.As(BasketPage.class).CheckAllItemsDeleted();

     }
    @After
    public void Teardown(){
        DriverContext.Browser.QuitBrowserCompletely();
    }

}
