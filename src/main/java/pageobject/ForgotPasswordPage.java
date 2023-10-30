package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    WebDriver driver;

    private static final String LOGIN_BUTTON = ".//a[@class='Auth_link__1fOlj']";

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public ForgotPasswordPage waitingForVisibilityLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_BUTTON)));
        return this;
    }

    public ForgotPasswordPage clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        return this;
    }
}
