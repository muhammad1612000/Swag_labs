package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class pageBase {
    // ToDO short explicit wait
    public static WebDriverWait shortwait (WebDriver driver){
        return  new WebDriverWait (driver,20);
    }



    // ToDO long explicit wait
    public static WebDriverWait longwait (WebDriver driver){
        return  new WebDriverWait (driver,50);
    }

// ToDo load page
public static void waitForPageLoad(WebDriver driver) {
    (new WebDriverWait(driver, (50))).until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver d) {
            JavascriptExecutor js = (JavascriptExecutor) d;
            String readyState = js.executeScript("return document.readyState").toString();
            //System.out.println("Ready State: " + readyState);
            return (Boolean) readyState.equals("complete");
        }
    });
}

}
