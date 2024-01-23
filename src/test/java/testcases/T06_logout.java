package testcases;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retry_test.Retry;

import static Pages.pageBase.waitForPageLoad;
import static testcases.T01_login.name;
import static testcases.T01_login.password;
import static util.Utility.captureScreenshot;

public class T06_logout extends Testbase{
    // ToDo try to logout button and if item will be deleted or not from cart
    @Test(priority = 1, description = "check the funtionality of logout button and if item will be deleted or not from cart")
    public void logout_scenario() {
        // ToDo wait page to load
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
        new P01_add_to_cart(driver).addcart2().addcart3();
        captureScreenshot(driver, "inventory page before(logout )  ");
        new P0_login(driver).Press_menu().click_logout();
        driver.navigate().refresh();
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
        captureScreenshot(driver, "inventory page after(logging in again )  ");
    }
}
