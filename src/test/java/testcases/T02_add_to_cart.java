package testcases;

import Pages.P0_login;
import Pages.P01_add_to_cart;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Pages.pageBase.waitForPageLoad;
import static testcases.T01_login.name;
import static testcases.T01_login.password;

public class T02_add_to_cart extends Testbase{

    @Test(priority = 1 , description = "add to cart with invalid scenario" )
    public void add_to_cart_valid(){
        // ToDo wait page to load
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
        new P01_add_to_cart(driver).addcart2();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(new P01_add_to_cart(driver).returncar2ttext(),"Remove");
        softassert.assertAll();
    }
    @Test(priority = 2 , description = "add to cart with invalid scenario" )
    public void add_to_cart_invalid(){
        // ToDo wait page to load
       waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
        new P01_add_to_cart(driver).addcart();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(new P01_add_to_cart(driver).returncarttext(),"remove");
        softassert.assertAll();

    }


}
