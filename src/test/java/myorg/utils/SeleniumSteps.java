package myorg.utils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static void waitUntilVisible(WebElement element) {
        int sec = Integer.parseInt(AutomationCore.getResourceBundle().getString("explicitWaitSec"));
        WebDriverWait wait = new WebDriverWait(AutomationCore.getDriver(),sec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isElementPresent(String locator) {
          return getElement(locator).isDisplayed();
    }

    public static void switchHandle(){
        String parentWindowHandler = AutomationCore.getDriver().getWindowHandle(); // Store your parent window
        String subWindowHandler = null;
        Set<String> handles = AutomationCore.getDriver().getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        AutomationCore.getDriver().switchTo().window(subWindowHandler); // switch to popup window
        AutomationCore.getDriver().switchTo().window(parentWindowHandler);  // switch back to parent window
    }
}
