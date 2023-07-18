package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage {
    WebDriver driver ;
    public CatalogPage (WebDriver driver){
        this.driver = driver;
    }

    By items = By.xpath("//*[@id=\"tab2\"]/label[2]");
    By product =By.xpath("//*[@id=\"Grid\"]/tbody/tr[9]/td[1]/div/div[2]/h2");
    By edit =By.xpath("//*[@id=\"Grid\"]/tbody/tr[9]/td[7]/div/a");

    By priceT = By.xpath("//*[@id=\"Grid\"]/tbody/tr[9]/td[5]/div/h2");

    public void clickOnItem() {
        driver.findElement(items).click();
    }
    public void findProduct () {
        List<WebElement> listofItems = driver.findElements(product);

        for (int i=1; i<=listofItems.size(); i++)
        {
            listofItems.get(i).click();
        }


    }
    public void navigatProduct(){
        driver.findElement(edit).click();
    }
    public String assertonPrice(){
        driver.findElement(priceT).getText();

        return null;
    }


}
