package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver ;
    public HomePage (WebDriver driver){
        this.driver = driver;

    }
    By catalog = By.xpath("/html/body/div/div/div/div[1]/div[2]/ul/li[1]/a");
    By branch = By.id("branch_layout_ids");

    public void dropdown(){
        driver.findElement(branch);
    }
     public void logtocatalog(){
         driver.findElement(catalog).click();

     }

}
