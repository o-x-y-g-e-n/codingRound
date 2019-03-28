package myorg.tests;
import myorg.utils.AutomationCore;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import myorg.pages.HomePage;
import myorg.pages.SignInPage;
import myorg.utils.ApplicationSteps;
import myorg.utils.SeleniumSteps;

public class SignInTest {


    @BeforeTest
    public void suitUp(){
    	ApplicationSteps.launchPage("/");
    }

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	HomePage homePage = new HomePage();
        homePage.openSignInTab();
        SignInPage signInPage = new SignInPage();
        signInPage.signInMe(" ", " ");
    	signInPage.verifyErrorPresent();
    }
    
}
