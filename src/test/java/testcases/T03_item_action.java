package testcases;
import Pages.P03_item;
import Pages.P0_login;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retry_test.Retry;

import static Pages.pageBase.waitForPageLoad;
import static testcases.T01_login.name;
import static testcases.T01_login.password;
import static util.Utility.captureScreenshot;
public class T03_item_action extends Testbase{

    @Test(priority = 1 , description = "comparing the item information ")
    public void checking_item_header_name(){
        // ToDo wait page to load
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
         String item_inventory = new P03_item(driver).return_item_text_inventory();
        captureScreenshot (driver,"Sauce Labs Fleece Jacket");
         new P03_item(driver).click_on_item();
         String itempage = new P03_item(driver).return_item_text();

        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(itempage,item_inventory);
        softassert.assertAll();



    }

}
