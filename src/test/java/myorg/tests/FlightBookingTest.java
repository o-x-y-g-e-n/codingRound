package myorg.tests;

import myorg.pages.FlightListPage;
import myorg.pages.FlightPage;
import myorg.pages.HomePage;
import myorg.utils.ApplicationSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest {


    @BeforeTest
    public void suitUp(){
        ApplicationSteps.launchPage("/flights");
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        FlightPage flightPage = new FlightPage();
        flightPage.searchAFlight("Bangalore","Delhi");
        FlightListPage flightListPage = new FlightListPage();
        flightListPage.waitUntilSearchSummaryDisplayed();
        flightListPage.verifySummaryPresent();
    }

}