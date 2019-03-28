package myorg.utils;

public class ApplicationSteps {

    public static void launchPage(String url) {

        // something is going to change here!!
        AutomationCore.getDriver().get(url);
    }
}
