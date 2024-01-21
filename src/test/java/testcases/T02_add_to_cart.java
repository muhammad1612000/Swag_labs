package testcases;

import Pages.P0_login;
import Pages.P1_add_to_cart;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retry_test.Retry;

import static Pages.pageBase.waitForPageLoad;
import static testcases.T01_login.name;
import static testcases.T01_login.password;
import static util.Utility.captureScreenshot;

public class T02_add_to_cart extends Testbase{
    @Test(priority = 1 , description = "add to cart with invalid scenario" )
    public void add_to_cart_invalid(){
        // ToDo wait page to load
       waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
        new P1_add_to_cart(driver).addcart();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(new P1_add_to_cart(driver).returncarttext(),"remove");
        softassert.assertAll();



    }
//    @Test(priority = 1 , description = "login with valid username and password " , retryAnalyzer = Retry.class)
//    public void login_with_valid_data() {
//        // ToDo wait page to load
//        waitForPageLoad(driver);
//        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
//        // shortwait(driver).until(ExpectedConditions.);
//        captureScreenshot (driver,"P_login");
//    }
//    @Test(priority = 2 , description = "login with valid username and  empty password ")
//    public void login_with_empty_password() {
//        waitForPageLoad(driver);
//        new P0_login(driver).fill_username(name).Press_login();
//        captureScreenshot (driver,"P_invalid_login ( empty password)");
//
//    }
}
