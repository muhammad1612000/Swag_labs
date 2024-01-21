package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import common.MyScreenRecorder;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.setDriver;
@Listeners(listener.Mylistener.class)
public class Testbase {
   public static WebDriver driver;
    Faker  faker = new Faker();
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private static String PROJECT_NAME = null;
    private static String PROJECT_URL = null;
    static Properties prop;
    static FileInputStream readProperty ;

//    private static Duration shortTimeout = Duration.ofSeconds(10);
//    private static Duration longTimeout =  Duration.ofSeconds(25);
   //  WebDriverWait shortWait = new WebDriverWait(driver, 10);
   // WebDriverWait longWait = new WebDriverWait(driver, 25);

@BeforeSuite
public void defineSuiteElements() throws Exception {
    // recording
  //  MyScreenRecorder.startRecording("e2e Swag_Labs");
    // initialize the HtmlReporter
    htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReport.html");

    //initialize ExtentReports and attach the HtmlReporter
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);

    setProjectDetails();

    // initialize test
    test = extent.createTest(PROJECT_NAME + " Test Automation Project");

    //configuration items to change the look and fee add content, manage tests etc
    htmlReporter.config().setDocumentTitle(PROJECT_NAME + " Test Automation Report");
    htmlReporter.config().setReportName(PROJECT_NAME + " Test Report");
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
}
    private void setProjectDetails() throws IOException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
    }

    @Parameters("browser")
    
    @BeforeTest
    public void setupdriver(String browser) throws InterruptedException {
        // ToDo: configurations' steps
         driver = DriverFactory.getNewInstance(browser);
        setDriver(driver);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PROJECT_URL);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
        Thread.currentThread().interrupt();
    }
    @AfterSuite
    public void tearDown() throws Exception {
    //stop recording
      //  MyScreenRecorder.stopRecording();
        extent.flush();
    }
    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName() + " failed with the following error: " + result.getThrowable());
            Reporter.log("Failed to perform "+result.getName(), 10, true);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
            Reporter.log("Successfully perform "+result.getName(), 10, true);
        } else {
            test.log(Status.SKIP, result.getName());
            Reporter.log("Skip "+result.getName(), 10, true);
        }
    }

}
