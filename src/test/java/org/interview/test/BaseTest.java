package org.interview.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;
import org.interview.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    @Getter
    public WebDriver driver;


    HomePage homePage;



    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fil = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/globalData.properties");
        prop.load(fil);
        System.out.println(prop.getProperty("browser"));
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }



    @BeforeClass(alwaysRun = true)
    public HomePage launchApplication() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        homePage.launchLandingPage();
        return new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();

    }

}

