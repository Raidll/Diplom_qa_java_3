package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    private final String INPUT_NAME = ".//fieldset[1]/div/div/input";
    private final String INPUT_EMAIL = ".//fieldset[2]/div/div/input";
    private final String INPUT_PASSWORD = ".//fieldset[3]/div/div/input";
    private final String REGISTRATION_BUTTON = ".//button[text()='Зарегистрироваться']";
    private final String INCORRECT_PASSWORD_NOTIFICATION = ".//p[@class='input__error text_type_main-default']";
    private final String LOGIN_BUTTON = ".//a[text()='Войти']";

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public RegistrationPage waitingForVisibilityNameInput() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_NAME)));
        return this;
    }

    public RegistrationPage fillName(String name) {
        driver.findElement(By.xpath(INPUT_NAME)).sendKeys(name);
        return this;
    }

    public RegistrationPage clickInputName() {
        driver.findElement(By.xpath(INPUT_NAME)).click();
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(email);
        return this;
    }

    public RegistrationPage fillPassword(String password) {
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(password);
        return this;
    }

    public RegistrationPage clickToRegistrationButton() {
        driver.findElement(By.xpath(REGISTRATION_BUTTON)).click();
        return this;
    }

    public RegistrationPage waitingForVisibilityIncorrectPasswordNotification() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INCORRECT_PASSWORD_NOTIFICATION)));
        return this;
    }

    public RegistrationPage clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        return this;
    }

    public RegistrationPage waitingForVisibilityLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_BUTTON)));
        return this;
    }
}
