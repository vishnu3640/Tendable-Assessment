package org.interview.pageobjects;

import org.interview.abstractcomponent.CommonComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactUsPage extends CommonComponents {
    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#form-input-fullName")
    WebElement firstName;
    @FindBy(css = "#form-input-organisationName")
    WebElement organisationName;
    @FindBy(css = "#form-input-cellPhone")
    WebElement mobileNumber;
    @FindBy(css = "#form-input-email")
    WebElement email;
    @FindBy(css = "#form-input-jobRole")
    WebElement jobRole;
    @FindBy(css = "#form-input-message")
    WebElement message;
    @FindBy(css = "#form-input-consentAgreed-0")
    WebElement radioButton;

    @FindBy(xpath = "(//div[@class='text-center']//div/button[contains(text(),'Contact')])[1]")
    WebElement contact;

    @FindBy(xpath = "//select[@id='form-input-jobRole']")
    WebElement dropDown;

    @FindBy(xpath = "//select[@id='form-input-jobRole']/option")
    List<WebElement> selectingText;

    @FindBy(xpath = "(//button[contains(text(),'Submit')])[1]")
    WebElement submitClick;

    @FindBy(xpath = "//div[@class='ff-form-errors']/p")
    WebElement errorMessage;





    WebDriver driver;

    public void submitForm()  {

        contact.click();

      firstName.sendKeys("Vishnu");
      email.sendKeys("vishnu@gmail.com");
      selectingJobRole();
      mobileNumber.sendKeys("9822669061");
      organisationName.sendKeys("Google");
      radioButton.click();
      submitClick.click();
    }

    public void selectingJobRole()
    {
        for(int i=0;i<selectingText.size();i++)
        {
            Select element = new Select(dropDown);
            element.selectByVisibleText("Management");
        }
    }

    public String validateErrorMessage()
    {
        waitForElementToBeVisible(errorMessage);
       return errorMessage.getText();
    }


}
