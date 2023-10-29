import createAndDeleteWebDriver.CreateWebDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.ConstructorPage;
import pageObject.HomePage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;


public class ConstructorTest {
    WebDriver driver = CreateWebDriver.createWebDriver();
    User user;

    @Before
    public void createRandomUser(){
        user = CreateRandomUserData.createRandomUserData();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        userApiMethods.sendRequestCreate();
    }

    @Test
    public void goToBunsSelection() {
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.waitingForVisibilitySauceSelection()
                .clickSauceSelection()
                .clickBunSelection();
        WebElement bunSectionHeader = driver.findElement(By.xpath(constructorPage.getBunSectionHeader()));
        WebElement currentSectionHeaderExpected = bunSectionHeader.findElement(By.xpath(constructorPage.getParentElement()));
        WebElement currentSectionHeaderActual = driver.findElement(By.xpath(constructorPage.getCurrentSectionHeader()));
        Assert.assertEquals(currentSectionHeaderExpected,currentSectionHeaderActual);
    }

    @Test
    public void goToSauceSelection() {
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.waitingForVisibilitySauceSelection()
                .clickSauceSelection();
        WebElement SauceSelectionHeader = driver.findElement(By.xpath(constructorPage.getSauceSelectionHeader()));
        WebElement currentSectionHeaderExpected = SauceSelectionHeader.findElement(By.xpath(constructorPage.getParentElement()));
        WebElement currentSectionHeaderActual = driver.findElement(By.xpath(constructorPage.getCurrentSectionHeader()));
        Assert.assertEquals(currentSectionHeaderExpected,currentSectionHeaderActual);

    }

    @Test
    public void goToFillingsSelection() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.waitingForVisibilitySauceSelection()
                .clickFillingsSelection();
        WebElement FillingSelectionHeader = driver.findElement(By.xpath(constructorPage.getFillingsSelectionHeader()));
        WebElement currentSectionHeaderExpected = FillingSelectionHeader.findElement(By.xpath(constructorPage.getParentElement()));
        WebElement currentSectionHeaderActual = driver.findElement(By.xpath(constructorPage.getCurrentSectionHeader()));
        Assert.assertEquals(currentSectionHeaderExpected,currentSectionHeaderActual);

    }

    @After
    public void teardown() {
        driver.quit();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        if (userApiMethods.isUserExist(user)) {
            userApiMethods.sendRequestLogin(user);
            userApiMethods.sendRequestDelete(user);
        }
    }
}
