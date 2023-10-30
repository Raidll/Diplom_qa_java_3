package webelementcomparison;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.ConstructorPage;

public class WebElementComparsion {
    private ConstructorPage constructorPage;
    private WebDriver driver;

    public WebElementComparsion(ConstructorPage constructorPage, WebDriver driver){
        this.constructorPage = constructorPage;
        this.driver = driver;
    }

    public boolean isBunSelectionSuccess(){
        WebElement bunSectionHeader = driver.findElement(By.xpath(constructorPage.getBunSectionHeader()));
        WebElement currentSectionHeaderExpected = bunSectionHeader.findElement(By.xpath(constructorPage.getParentElement()));
        WebElement currentSectionHeaderActual = driver.findElement(By.xpath(constructorPage.getCurrentSectionHeader()));
        return currentSectionHeaderExpected.equals(currentSectionHeaderActual);
    }

    public boolean isSauceSelectionSuccess(){
        WebElement SauceSelectionHeader = driver.findElement(By.xpath(constructorPage.getSauceSelectionHeader()));
        WebElement currentSectionHeaderExpected = SauceSelectionHeader.findElement(By.xpath(constructorPage.getParentElement()));
        WebElement currentSectionHeaderActual = driver.findElement(By.xpath(constructorPage.getCurrentSectionHeader()));
        return currentSectionHeaderExpected.equals(currentSectionHeaderActual);
    }

    public boolean isFillingSelectionSuccess(){
        WebElement FillingSelectionHeader = driver.findElement(By.xpath(constructorPage.getFillingsSelectionHeader()));
        WebElement currentSectionHeaderExpected = FillingSelectionHeader.findElement(By.xpath(constructorPage.getParentElement()));
        WebElement currentSectionHeaderActual = driver.findElement(By.xpath(constructorPage.getCurrentSectionHeader()));
        return currentSectionHeaderExpected.equals(currentSectionHeaderActual);
    }
}
