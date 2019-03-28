package myorg.tests;
import myorg.pages.HomePage;
import myorg.pages.HotelsPage;
import myorg.utils.ApplicationSteps;
import myorg.utils.AutomationCore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest {

    @BeforeTest
    public void suitUp(){
        ApplicationSteps.launchPage("/");
        PageFactory.initElements(AutomationCore.getDriver(), this);
    }
    @Test
    public void shouldBeAbleToSearchForHotels() {
        HomePage homePage = new HomePage();
        homePage.navigateToHotelsTab();
        HotelsPage hotelsPage = new HotelsPage();
        hotelsPage.searchForAnHotel("Indiranagar, Banglore","1 room, 2 adults");
    }

}
