package testcases;

import Pages.P0_login;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import retry_test.Retry;
import util.Utility;

import java.io.IOException;

import static Pages.pageBase.shortwait;
import static Pages.pageBase.waitForPageLoad;
import static util.Utility.captureScreenshot;
import static util.Utility.getSingleJsonData;


public class T01_login extends Testbase{

    // ToDo : use json as data  driven
   static String name;

    static {
        try {
            name = getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/logindata.json","username");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static String password;

    static {
        try {
            password = getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/logindata.json","password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static String wrong_name;

    static {
        try {
            wrong_name = getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/logindata.json","invalid_username");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static String wrong_password;

    static {
        try {
            wrong_password = getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data_driven/logindata.json","inavlid_password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public T01_login() throws IOException, ParseException {

    }
    @Test(priority = 1 , description = "login with valid username and password " , retryAnalyzer = Retry.class)
    public void login_with_valid_data() {
        // ToDo wait page to load
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(password).Press_login();
       // shortwait(driver).until(ExpectedConditions.);
        captureScreenshot (driver,"P_login");
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(new P0_login(driver).retrun_header_value(),"Products");
        softAssert.assertAll();
    }
    @Test(priority = 2 , description = "login with valid username and  empty password ")
    public void login_with_empty_password() {
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).Press_login();
        captureScreenshot (driver,"P_invalid_login ( empty password)");

    }
    @Test(priority = 3 , description = "login with empty username and  valid password ")
    public void login_with_empty_username() {
        waitForPageLoad(driver);
        new P0_login(driver).fill_password(password).Press_login();
        captureScreenshot (driver,"P_invalid_login (empty username)");
    }
    @Test(priority = 4 , description = "login with empty username and password ")
    public void login_with_empty_username_and_password() {
        waitForPageLoad(driver);
        new P0_login(driver).Press_login();
        captureScreenshot (driver,"P_invalid_login (empty data)");
    }
    @Test(priority = 5 , description = "login with valid username and invalid password ")
    public void login_with_valid_username_and_invalid_password() {
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(name).fill_password(wrong_password).Press_login();
        captureScreenshot (driver,"P_invalid_login (invalid password)");
    }
    @Test(priority = 6 , description = "login  with invalid  username and valid password ")
    public void login_with_invalid_username_and_valid_password() {
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(wrong_name).fill_password(password).Press_login();
        captureScreenshot (driver,"P_invalid_login (invalid username)");
    }
    @Test(priority = 7 , description = "login with invalid username and password ")
    public void login_with_invalid_username_and_invalid_password() {
        waitForPageLoad(driver);
        new P0_login(driver).fill_username(wrong_name).fill_password(wrong_password).Press_login();
        captureScreenshot (driver,"P_invalid_login (invalid data)");
    }
}
