package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.pageBase.longwait;
import static Pages.pageBase.shortwait;

public class P04_checkout {
    WebDriver driver;
    public P04_checkout(WebDriver driver){
        this.driver = driver;
    }
    private final By fname = By.id("first-name");
    private final By lname = By.id("last-name");
    private final By zpcode = By.id("postal-code");
    private final By continue_button = By.id("continue");
    public P04_checkout fill_first_username(String name ){
            //  ToDo: call wait
            try {
                shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.fname));
            }catch (TimeoutException ex) {
                ex.printStackTrace();
            }
            driver.findElement(this.fname).sendKeys(name);
            return  this;
        }
        public  P04_checkout fill_last_name(String name){

            try {
                shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.lname));
            } catch (TimeoutException ex ){
                ex.printStackTrace();
            }
            driver.findElement(this.lname).sendKeys(name);
            return this;
        }

      public  P04_checkout fill_zpcode(String name){

                try {
                    shortwait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.zpcode));
                } catch (TimeoutException ex ){
                    ex.printStackTrace();
                }
                driver.findElement(this.zpcode).sendKeys(name);
                return this;
            }
        public P04_checkout Press_continue (){
            try {
                longwait(driver).until(ExpectedConditions.elementToBeClickable(this.continue_button));
            }catch (TimeoutException ex ){
                ex.printStackTrace();
            }
            driver.findElement(this.continue_button).click();
            return  this;
        }


}
