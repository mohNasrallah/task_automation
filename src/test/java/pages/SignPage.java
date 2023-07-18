package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignPage {
    WebDriver driver;
    public SignPage (WebDriver driver){
        this.driver = driver ;
    }
    By emailBox = By.name("email");
    By passwordBox = By.name("password");
    By login = By.xpath("/html/body/div/div/div[2]/form/ul/li[4]/input");

    public void loginset(String emailkey , String passKey){
        driver.findElement(emailBox).sendKeys(emailkey);
        driver.findElement(passwordBox).sendKeys(passKey);
        driver.findElement(login).click();
    }
}
