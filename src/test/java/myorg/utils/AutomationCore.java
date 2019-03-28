package myorg.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationCore {
    private static WebDriver myDriver = null;

    public static WebDriver getChromeDriver(){
        if(myDriver == null) {
            DriverPathUtil.assignMeADriver();
            myDriver = new ChromeDriver();
            return myDriver;

        }
        else
            return myDriver;
    }

    public static WebDriver getDriver(){
        // this is my default driver ----- Dude, call me if you don't understand any of this s**t!
        return getChromeDriver();
    }
    public static void getFireFoxDriver(){
        // here goes the respective code for the geckodriver ;;
    }
}
