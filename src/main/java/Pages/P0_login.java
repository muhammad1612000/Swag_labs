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
    // TOdo : loign data
    private final By username = By.id("user-name");
//id="add-to-cart-sauce-labs-fleece-jacket"

    private final By password = By.id("password");
   private final By login  = By.id("login-button");
    public P0_login fill_username(String name ){
        //  ToDo: call wait
        shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.username));
        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.username));
        }catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.username).sendKeys(name);
        return  this;
    }
    public  P0_login fill_password(String pw){
        shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        try {
            shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        } catch (TimeoutException ex ){
            ex.printStackTrace();
        }
        driver.findElement(this.password).sendKeys(pw);
        return this;
    }
    public P0_login Press_login (){
        longwait(driver).until(ExpectedConditions.elementToBeClickable(this.login));
        try {
            longwait(driver).until(ExpectedConditions.elementToBeClickable(this.login));
        }catch (TimeoutException ex ){
            ex.printStackTrace();
        }
        driver.findElement(this.login).click();
        return  this;
    }
    // ToDo : header message in login page (products)
    private final By header_loign = By.className("title");
    public String retrun_header_value(){
        return driver.findElement(this.header_loign).getText();

    }
        // TODo : related to reset app test case
    private final By menu_button = By.id("react-burger-menu-btn");
    private final By reset_button = By.id("reset_sidebar_link");
    public  P0_login Press_menu (){
        longwait(driver).until(ExpectedConditions.elementToBeClickable(this.menu_button));
        try {
            longwait(driver).until(ExpectedConditions.elementToBeClickable(this.menu_button));
        }catch (TimeoutException ex ){
            ex.printStackTrace();
        }
        driver.findElement(this.menu_button).click();
        return  this;
    }
    public  P0_login click_reset (){
        longwait(driver).until(ExpectedConditions.elementToBeClickable(this.reset_button));
        try {
            longwait(driver).until(ExpectedConditions.elementToBeClickable(this.reset_button));
        }catch (TimeoutException ex ){
            ex.printStackTrace();
        }
        driver.findElement(this.reset_button).click();
        return  this;
    }
    // ToDo  logout test case
    private final By logout_button = By.id("logout_sidebar_link");
    public  P0_login click_logout (){
        longwait(driver).until(ExpectedConditions.elementToBeClickable(this.logout_button));
        try {
            longwait(driver).until(ExpectedConditions.elementToBeClickable(this.logout_button));
        }catch (TimeoutException ex ){
            ex.printStackTrace();
        }
        driver.findElement(this.logout_button).click();
        return  this;
    }
}


