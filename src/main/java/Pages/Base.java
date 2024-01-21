package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Base {
    static WebDriver driver;
    public static void  hooverfn(By xpath){
       WebElement ele = driver.findElement(xpath);
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();

    }
}
