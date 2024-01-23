package testcases;
import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retry_test.Retry;

import static Pages.pageBase.waitForPageLoad;
import static testcases.T01_login.name;
import static testcases.T01_login.password;
import static util.Utility.captureScreenshot;
public class T04_make_order extends Testbase {
    // ToDo : using java faker for data driven
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String zipcode = faker.address().zipCode();

    // ToDo try to make order but it is blocking
    @Test(priority = 1, description = "comparing the item information ")
    public void making_order_with_blocking_scenraio() {
        // ToDo wait page to load
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();


        new P01_add_to_cart(driver).addcart2().addcart3();

        new P02_cart(driver).click_on_cart();
        captureScreenshot(driver, "cart page ");
        new P02_cart(driver).click_on_chceckout();
        captureScreenshot(driver, "checkout page  ");
        new P04_checkout(driver).fill_first_username(firstname).fill_last_name(lastname).fill_zpcode(zipcode).Press_continue();
        String expected = "https://www.saucedemo.com/checkout-step-two.html";
        SoftAssert softassert = new SoftAssert();
          softassert.assertEquals(driver.getCurrentUrl(),expected);
             softassert.assertAll();
          }

    }

