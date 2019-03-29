package myorg.pages;

import myorg.utils.AutomationCore;
import myorg.utils.SeleniumSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {
    @FindBy(id="OneWay")
    private WebElement oneWay;

    @FindBy(id="FromTag")
    private WebElement fromTag;

    @FindBy(id="ToTag")
    private WebElement toTag;

    @FindBy(xpath="//ul[@id='ui-id-1']/li/a")
    private WebElement fromListing;

    @FindBy(xpath="//ul[@id='ui-id-2']/li/a")
    private WebElement toListing;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[7]/a")
    private WebElement datePickerItem;

    @FindBy(id="SearchBtn")
    private WebElement searchBtn;

    public FlightPage(){
        PageFactory.initElements(AutomationCore.getDriver(), this);
    }

    public void searchAFlight(String from,String to){
        oneWay.click();
        fromTag.sendKeys(from);
        SeleniumSteps.waitFor(2000);
        SeleniumSteps.waitUntilVisible(fromListing);
        fromListing.click();
        SeleniumSteps.waitFor(2000);
        toTag.sendKeys(to);
        SeleniumSteps.waitUntilVisible(toListing);
        toListing.click();
        datePickerItem.click();
        SeleniumSteps.waitUntilVisible(searchBtn);
        searchBtn.click();
    }
}
