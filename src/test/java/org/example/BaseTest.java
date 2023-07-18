package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SignPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver ;
    @BeforeTest
     public void beforetest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://transmission-dev.azurewebsites.net/login");
        driver.manage().window().maximize();


    }
    @AfterTest
    public void aftertest(){
        driver.quit();
    }
    @Test
    public void method() throws InterruptedException {

        // insert pages
        SignPage sign = new SignPage(driver);
        HomePage home = new HomePage(driver);
        CatalogPage cat = new CatalogPage(driver);
        ProductPage product = new ProductPage(driver);



        //test process

        ////login using valid email and password
        sign.loginset("testbotitb2@dist.com","123456");
        /// navigate to catalog
        home.logtocatalog();
        ////navigate to item then the product
        cat.clickOnItem();
        cat.findProduct();
        cat.navigatProduct();
        //// change product price
        product.changeprice();
        ///find product on table
        cat.clickOnItem();
        cat.findProduct();
        //// assert on the price
        String Eexpected = "200 EGP";
        String Actual = cat.assertonPrice();
        Assert.assertEquals(Eexpected,Actual);

    }

}
