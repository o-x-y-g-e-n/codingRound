package myorg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import myorg.utils.AutomationCore;
import myorg.utils.SeleniumSteps;

public class SignInPage {
	
	@FindBy(id="signInButton")
	private  WebElement signInBtn;
	@FindBy(id="errors1")
	private  WebElement errorContainer;
	@FindBy(id="email")
	private  WebElement usernameElement;
	@FindBy(id="password")
	private  WebElement passwordElement;

	public SignInPage(){
		PageFactory.initElements(AutomationCore.getDriver(), this);

	}

	/**
	 * Sign User In 
	 * @param username
	 * @param password
	 */
	public void signInMe(String username,String password) {
		AutomationCore.getDriver().switchTo().frame(1);
		SeleniumSteps.waitUntilVisible(usernameElement);
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		signInBtn.click();
	}

	/**
	 * This checks if error is thrown
	 * @return
	 */
	public  boolean isErrorPresent() {
		// this (id=errors1) couldn't be hardcoded... // finding an workaround
		String errors1 = SeleniumSteps.getElement("id=errors1").getText();
        if(errors1.contains("There were errors in your submission")) return true;
        else return false;
	}
	/**
	 * Assert if error is present or not
	 */
	public void verifyErrorPresent() {
		Assert.assertEquals(isErrorPresent(), true);
	}
}
