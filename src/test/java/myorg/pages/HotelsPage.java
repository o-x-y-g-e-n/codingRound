package myorg.pages;

import myorg.utils.AutomationCore;
import myorg.utils.SeleniumSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelsPage {
    @FindBy(name="from")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @FindBy(xpath="//*[@class='autoComplete']/li[2]")
    private WebElement hotelListing;

    public HotelsPage(){
        PageFactory.initElements(AutomationCore.getDriver(), this);

    }

    public void searchForAnHotel(String param,String travellersText){
        SeleniumSteps.waitUntilVisible(localityTextBox);
        localityTextBox.sendKeys(param);
        SeleniumSteps.waitUntilVisible(hotelListing);
        hotelListing.click();
        SeleniumSteps.selectFromDropBox(travellerSelection,travellersText);
        searchButton.click();
    }

}
