package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    private static final String BUTTON_PERSONAL_ACCOUNT = ".//p[text()='Личный Кабинет']";
    private static final String LOGIN_BUTTON = ".//button[text()='Войти в аккаунт']";
    private static final String CREATE_ORDER_BUTTON = ".//button[text()='Оформить заказ']";
    private static final String CONSTRUCTOR_BUTTON = ".//p[text()='Конструктор']";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage clickButtonPersonalAccount(){
        driver.findElement(By.xpath(BUTTON_PERSONAL_ACCOUNT)).click();
        return this;
    }

    public HomePage waitingForVisibilityPersonalAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_PERSONAL_ACCOUNT)));
        return this;
    }

    public HomePage clickLoginButton(){
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
        return this;
    }

    public HomePage waitingForVisibilityLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_BUTTON)));
        return this;
    }

    public HomePage waitingForVisibilityCreateOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_ORDER_BUTTON)));
        return this;
    }

    public HomePage waitingForVisibilityConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONSTRUCTOR_BUTTON)));
        return this;
    }

    public HomePage clickConstructorButton() {
        driver.findElement(By.xpath(CONSTRUCTOR_BUTTON)).click();
        return this;
    }
}
