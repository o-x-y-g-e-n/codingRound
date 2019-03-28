package myorg.utils;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
public class SeleniumSteps {

    public static WebElement getElement(String locator){
        // locator comes in the form --> id=something or xpath=something
        String[] temp = locator.split("=");
        String prefix = temp[0];
        String suffix = temp[1];
        if(prefix.equalsIgnoreCase("ID")) return AutomationCore.getDriver().findElement(By.id(suffix));
        else if(prefix.equalsIgnoreCase("XPATH")) return AutomationCore.getDriver().findElement(By.xpath(suffix));
        else if(prefix.equalsIgnoreCase("CLASSNAME")) return AutomationCore.getDriver().findElement(By.className(suffix));
        else if(prefix.equalsIgnoreCase("CSSSELECTOR")) return AutomationCore.getDriver().findElement(By.cssSelector(suffix));
        else if(prefix.equalsIgnoreCase("TEXT")) {
            String myXpath ="//*[contains(text(), '"+ suffix + "')]";
            return AutomationCore.getDriver().findElement(By.xpath(myXpath));
        }
        else if(prefix.equalsIgnoreCase("LINKTEXT"))  return AutomationCore.getDriver().findElement(By.linkText(suffix));
        // this loop continous... add as many as you want!
        return null;
    }

    public static List<WebElement> getElements(String locator){
        String[] temp = locator.split("=");
        String prefix = temp[0];
        String suffix = temp[1];
        if(prefix.equalsIgnoreCase("ID")) return AutomationCore.getDriver().findElements(By.id(suffix));
        else if(prefix.equalsIgnoreCase("XPATH")) return AutomationCore.getDriver().findElements(By.xpath(suffix));
        else if(prefix.equalsIgnoreCase("CLASSNAME")) return AutomationCore.getDriver().findElements(By.className(suffix));
        else if(prefix.equalsIgnoreCase("CSSSELECTOR")) return AutomationCore.getDriver().findElements(By.cssSelector(suffix));
        else if(prefix.equalsIgnoreCase("TEXT")) {
            String myXpath ="//*[contains(text(), '"+ suffix + "')]";
            return AutomationCore.getDriver().findElements(By.xpath(myXpath));
        }else if(prefix.equalsIgnoreCase("LINKTEXT"))  return AutomationCore.getDriver().findElements(By.linkText(suffix));

        // this loop continous... add as many as you want!
        return null;
    }

    public static void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
    private boolean isElementPresent(String locator) {
          return getElement(locator).isDisplayed();
    }
}
