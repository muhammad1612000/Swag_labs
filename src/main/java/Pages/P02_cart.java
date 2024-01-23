package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.pageBase.longwait;
import static Pages.pageBase.shortwait;

public class P02_cart {
    WebDriver driver;
    public P02_cart(WebDriver driver){
        this.driver = driver;
    }

    // ToDO : click on cart icon and open the icon to complete the purchasing
    private final By cart_button = By.cssSelector("a[class=\"shopping_cart_link\"]");
    public P02_cart click_on_cart(){
        //  call wait
        try {
            longwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cart_button));
        }catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.cart_button).click();
        return this;
    }
    private final By chceckout_button = By.id("checkout");
    private final By continue_button = By.id("continue");
    // ToDO : click on checkout button and open the icon to complete the purchasing
    public P02_cart click_on_chceckout() {
        //  call wait
        try {
            longwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.chceckout_button));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.chceckout_button).click();
        return this;
    }


}
