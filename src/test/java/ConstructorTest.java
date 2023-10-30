import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.HomePage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;
import user.UserEmailAndNameModel;
import webelementcomparison.WebElementComparsion;


public class ConstructorTest {
    DriverFactory driverFactory = new DriverFactory();
    User user;

    public ConstructorTest() throws InterruptedException {
    }



    @Test
    public void goToBunsSelection() {
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driverFactory.getDriver());
        constructorPage.waitingForVisibilitySauceSelection()
                .clickSauceSelection()
                .clickBunSelection();
        WebElementComparsion webElementComparsion = new WebElementComparsion(constructorPage, driverFactory.driver);
        Assert.assertTrue(webElementComparsion.isBunSelectionSuccess());
    }

    @Test
    public void goToSauceSelection() {
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driverFactory.getDriver());
        constructorPage.waitingForVisibilitySauceSelection()
                .clickSauceSelection();
        WebElementComparsion webElementComparsion = new WebElementComparsion(constructorPage, driverFactory.driver);
        Assert.assertTrue(webElementComparsion.isSauceSelectionSuccess());
    }

    @Test
    public void goToFillingsSelection() throws InterruptedException {
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driverFactory.getDriver());
        constructorPage.waitingForVisibilitySauceSelection()
                .clickFillingsSelection();
        WebElementComparsion webElementComparsion = new WebElementComparsion(constructorPage, driverFactory.driver);
        Assert.assertTrue(webElementComparsion.isFillingSelectionSuccess());
    }

    @After
    public void teardown() {
        driverFactory.getDriver().quit();
    }
}
