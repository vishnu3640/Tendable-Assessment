package org.interview.pageobjects;

import org.interview.abstractcomponent.CommonComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StoryPage extends CommonComponents {
    public StoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver;

    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }







}
