package myorg.pages;

import myorg.utils.AutomationCore;
import myorg.utils.SeleniumSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FlightListPage {

    @FindBy(className = "searchSummary")
    private WebElement searchSummaryTxt;

    public FlightListPage(){
        PageFactory.initElements(AutomationCore.getDriver(), this);
    }

    public boolean isSearchSummaryPresent(){
        if(searchSummaryTxt.isDisplayed()) return true;
        else return false;
    }

    public void verifySummaryPresent(){
        Assert.assertEquals(isSearchSummaryPresent(),true);
    }

    public void waitUntilSearchSummaryDisplayed(){
        SeleniumSteps.waitUntilVisible(searchSummaryTxt);
    }
}
