package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.pageBase.shortwait;

public class P01_add_to_cart {
    WebDriver driver;
    public P01_add_to_cart(WebDriver driver){
        this.driver = driver;
    }
    // ToDo : item Sauce Labs Fleece Jacket
    private final By cart = By.id("add-to-cart-sauce-labs-fleece-jacket");

    public P01_add_to_cart addcart( ){
        // call wait
        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cart));
        }catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.cart).click();
        return  this;
    }
    //ToDo: get the text of the  button after click on it (failed)
    public String returncarttext (){
        return driver.findElement(this.cart).getText();
    }

    // ToDo : Sauce Labs Bike Light

    private final By cart2 = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cart2_remove = By.id("remove-sauce-labs-bike-light");

    public P01_add_to_cart addcart2( ){
        // call wait
        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cart2));
        }catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.cart2).click();
        return  this;
    }
    //ToDo: get the text of the  button after click on it (pass)
    public String returncar2ttext (){
        return driver.findElement(this.cart2_remove).getText();
    }

    //ToDo: Sauce Labs Backpack
    private final By cart3 = By.id("add-to-cart-sauce-labs-backpack");
    public P01_add_to_cart addcart3( ){
        // call wait
        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cart3));
        }catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.cart3).click();
        return  this;
    }


}
