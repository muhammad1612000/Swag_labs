package testcases;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retry_test.Retry;

import static Pages.pageBase.waitForPageLoad;
import static testcases.T01_login.name;
import static testcases.T01_login.password;
import static util.Utility.captureScreenshot;

public class T05_reset_button extends Testbase {
    // ToDo try to reset button and check if its working
    @Test(priority = 1, description = "check the funtionality of reset button ")
    public void reset_cart() {
        // ToDo wait page to load
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
        new P01_add_to_cart(driver).addcart2().addcart3();
        captureScreenshot(driver, "inventory page before(reset button)  ");
        new P0_login(driver).Press_menu().click_reset();
        driver.navigate().refresh();
        captureScreenshot(driver, "inventory page after(reset button)  ");
    }
}
