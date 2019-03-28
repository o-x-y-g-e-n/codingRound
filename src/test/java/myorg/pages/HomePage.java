package myorg.pages;

import myorg.utils.AutomationCore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(id="userAccountLink")
	private  WebElement tripsButton;

	@FindBy(id="SignIn")
	private  WebElement signInLnk;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	public  WebElement getSignInLnk() {
		return signInLnk;
	}

	public HomePage(){
		PageFactory.initElements(AutomationCore.getDriver(), this);

	}
	public void openSignInTab() {
		tripsButton.click();
		signInLnk.click();
	}

	public void navigateToHotelsTab(){
		hotelLink.click();
	}
}
