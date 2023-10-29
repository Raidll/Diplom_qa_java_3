package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;

    private static final String SAVE_BUTTON = ".//button[text()='Сохранить']";
    private static final String CONSTRUCTOR_BUTTON = ".//p[text()='Конструктор']";
    private static final String STELLAR_BURGERS_LOGO = ".//div[@class='AppHeader_header__logo__2D0X2']";
    private static final String LOGOUT_BUTTON = ".//button[text()='Выход']";

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }


    public ProfilePage waitingForVisibilitySaveButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_BUTTON)));
        return this;
    }

    public ProfilePage waitingForVisibilityConstructorButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONSTRUCTOR_BUTTON)));
        return this;
    }

    public ProfilePage clickConstructorButton() {
        driver.findElement(By.xpath(CONSTRUCTOR_BUTTON)).click();
        return this;
    }

    public ProfilePage waitingForVisibilityLogoButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(STELLAR_BURGERS_LOGO)));
        return this;
    }

    public ProfilePage clickLogoButton() {
        driver.findElement(By.xpath(STELLAR_BURGERS_LOGO)).click();
        return this;
    }

    public ProfilePage waitingForVisibilityLogoutButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGOUT_BUTTON)));
        return this;
    }

    public ProfilePage clickLogoutButton() {
        driver.findElement(By.xpath(LOGOUT_BUTTON)).click();
        return this;
    }
}
