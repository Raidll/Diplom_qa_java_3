package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    private static final String INPUT_EMAIL = ".//fieldset[1]/div/div/input";
    private static final String INPUT_PASSWORD = ".//label[text()='Пароль']/following-sibling::input";
    private static final String LOGIN_BUTTON = "//*[@id=\"root\"]/div/main/div/form/button";
    private static final String REGISTRATION_BUTTON = ".//a[@href='/register']";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage waitingForVisibilityEmailInput() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_EMAIL)));
        return this;
    }

    public LoginPage clickEmailInput() {
        driver.findElement(By.xpath(INPUT_EMAIL)).click();
        return this;
    }

    public LoginPage fillEmail(String email) {
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(email);
        return this;
    }

    public LoginPage fillPassword(String password) {
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(password);
        return this;
    }

    public LoginPage waitingForVisibilityLoginButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_BUTTON)));
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        return this;
    }

    public LoginPage clickRegistrationButton() {
        driver.findElement(By.xpath(REGISTRATION_BUTTON)).click();
        return this;
    }
}
