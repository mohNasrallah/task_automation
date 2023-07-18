package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver ;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public  ProductPage (WebDriver driver){
        this.driver = driver ;

    }
    By priceBox = By.name("mainPrice");
    By submit = By.className("exit-button");

    public void changeprice(){
        js.executeScript("arguments[0].scrollIntoView();", priceBox);
        driver.findElement(priceBox).clear();
        driver.findElement(priceBox).sendKeys("200");
    }
}
