package org.interview.abstractcomponent;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CommonComponents {
    static WebDriver driver;

    public CommonComponents(WebDriver driver) {
        this.driver = driver;
    }



    public void waitForElementToBeVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOf(element));
    }




    public static String takeScreenshots(String testCaseName, WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String destination = "src/test/java/org/interview/screenshots/" + testCaseName + ".png";
        try {
            FileUtils.copyFile(src, new File(destination));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destination;
    }
}
