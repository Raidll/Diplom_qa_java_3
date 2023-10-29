package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPage {
    private WebDriver driver;

    private static final String CREATE_ORDER = ".//button[text()='Оформить заказ']";
    private static final String BUN_SELECTION = ".//span[text()='Булки']";
    private static final String SAUCE_SELECTION = ".//span[text()='Соусы']";
    private static final String FILLINGS_SELECTION = ".//span[text()='Начинки']";
    private static final String PARENT_ELEMENT = "..";
    private static final String CURRENT_SELECTION_HEADER = "//div[contains(@class, 'tab_type_current')]";


    public ConstructorPage(WebDriver driver){
        this.driver = driver;
    }

    public String getBunSectionHeader() {
        return BUN_SELECTION;
    }

    public String getSauceSelectionHeader() {
        return SAUCE_SELECTION;
    }

    public String getFillingsSelectionHeader(){
        return FILLINGS_SELECTION;
    }

    public ConstructorPage waitingForVisibilityCreateOrderButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_ORDER)));
        return this;
    }

    public ConstructorPage waitingForVisibilityBunSelection() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUN_SELECTION)));
        return this;
    }

    public ConstructorPage clickBunSelection() {
        driver.findElement(By.xpath(BUN_SELECTION)).click();
        return this;
    }

    public ConstructorPage waitingForVisibilitySauceSelection() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAUCE_SELECTION)));
        return this;
    }

    public ConstructorPage clickSauceSelection() {
        driver.findElement(By.xpath(SAUCE_SELECTION)).click();
        return this;
    }

    public ConstructorPage waitingForVisibilityFillingsSelection() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILLINGS_SELECTION)));
        return this;
    }

    public ConstructorPage clickFillingsSelection() {
        driver.findElement(By.xpath(FILLINGS_SELECTION)).click();
        return this;
    }

    public String getParentElement(){
        return PARENT_ELEMENT;
    }

    public String getCurrentSectionHeader() {
        return CURRENT_SELECTION_HEADER;
    }
}
