package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.pageBase.longwait;
import static Pages.pageBase.shortwait;

public class P0_login {
    WebDriver driver;
    public P0_login(WebDriver driver){
        this.driver = driver;
    }
    private final By username = By.id("user-name");
//id="add-to-cart-sauce-labs-fleece-jacket"

    private final By password = By.id("password");
   private final By login  = By.id("login-button");
    public P0_login fill_username(String name ){
        // call wait
        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.username));
        }catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.username).sendKeys(name);
        return  this;
    }
    public  P0_login fill_password(String pw){

        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        } catch (TimeoutException ex ){
            ex.printStackTrace();
        }
        driver.findElement(this.password).sendKeys(pw);
        return this;
    }
    public P0_login Press_login (){
        try {
            longwait(driver).until(ExpectedConditions.elementToBeClickable(this.login));
        }catch (TimeoutException ex ){
            ex.printStackTrace();
        }
        driver.findElement(this.login).click();
        return  this;
    }

}


