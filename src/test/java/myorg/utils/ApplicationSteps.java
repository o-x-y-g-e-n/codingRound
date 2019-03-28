package myorg.utils;

import java.util.ResourceBundle;

public class ApplicationSteps {

    public static void launchPage(String url) {
    	AutomationCore.getDriver().manage().window().maximize();
    	String baseUrl = AutomationCore.getResourceBundle().getString("baseUrl");
    	System.out.println(baseUrl);
    	AutomationCore.getDriver().get(baseUrl + url);
    }
}
