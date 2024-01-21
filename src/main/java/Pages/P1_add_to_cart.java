package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.pageBase.shortwait;

public class P1_add_to_cart {
    WebDriver driver;
    public P1_add_to_cart(WebDriver driver){
        this.driver = driver;
    }
    private final By cart = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public P1_add_to_cart addcart( ){
        // call wait
        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cart));
        }catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.cart).click();
        return  this;
    }
    public String returncarttext (){
        return driver.findElement(this.cart).getText();
    }



}
