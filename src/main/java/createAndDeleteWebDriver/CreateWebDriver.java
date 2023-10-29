package createAndDeleteWebDriver;

import org.openqa.selenium.WebDriver;
import webDriver.WebDriverSelector;

public class CreateWebDriver {
    public static WebDriver createWebDriver(){
        //return new WebDriverSelector().getWebDriver("yandex");
        return   new WebDriverSelector().getWebDriver("chrome");
    }
}
