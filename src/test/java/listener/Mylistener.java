package listener;

import common.MyScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static testcases.Testbase.driver;
public class Mylistener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("now running  " +result.getName());

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test succeeded "+result.getMethod());
    }

    public void onTestFailure(ITestResult result) {
        // take screenshot on test failure
        takeScreenshot();
        System.out.println(result.getThrowable());
    }


    public void onStart(ITestContext context) {
//        try {
//            MyScreenRecorder.startRecording(context.getName());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public void onFinish(ITestContext context) {
//        try {
//            MyScreenRecorder.stopRecording();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }
    public void takeScreenshot(){

      //  WebDriver driver=new ChromeDriver();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate=new Date();
        String screenshotName="Failed"+currntDate.toString().replace(" ","-").replace(":","-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/"+ screenshotName + ".png"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }
}
