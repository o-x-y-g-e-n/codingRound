package myorg.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationCore {
    private static WebDriver myDriver = null;
    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    public static WebDriver getChromeDriver(){
        if(myDriver == null) {
            System.out.println(rb.getString("chromePath"));
            System.setProperty("webdriver.chrome.driver",rb.getString("chromePath"));
            myDriver = new ChromeDriver();
            return myDriver;
        }
        else
            return myDriver;
    }
    
    public static ResourceBundle getResourceBundle() {
    	return rb;
    }
    public static WebDriver getDriver(){
        // this is my default driver
        return getChromeDriver();
    }
    public static void getFireFoxDriver(){
        // here goes the respective code for the geckodriver ;;
    }
}
