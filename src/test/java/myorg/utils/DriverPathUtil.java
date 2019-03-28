package myorg.utils;

import jdk.internal.jline.internal.Log;

public class DriverPathUtil {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void assignMeADriver(){
        if (isWindows()) {
            Log.debug("OS_VERSION","You are using WINDOwS");
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else if (isMac()) {
            Log.debug("OS_VERSION","You are using a MAC");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        } else if (isUnix()) {
            Log.debug("OS_VERSION","You are using UNIX");
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }else {
            System.out.println("Your OS is not support!!");
        }
    }
    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

}
