import baseURL.BaseUrl;
import createAndDeleteWebDriver.CreateWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.ConstructorPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProfilePage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;

public class PersonalAccountTest {
    WebDriver driver = CreateWebDriver.createWebDriver();
    User user;

    @Before
    public void createRandomUser(){
        user = CreateRandomUserData.createRandomUserData();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        userApiMethods.sendRequestCreate();
    }

    @Test
    public void goToPersonalAccount(){
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitingForVisibilitySaveButton();
    }

    @Test
    public void goToConstructorTest() {
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void goToConstructorClickOnLogo() {
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitingForVisibilityLogoButton()
                .clickLogoButton();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void LogoutButtonTest() {
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitingForVisibilityLogoutButton()
                .clickLogoutButton();
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        loginPage.waitingForVisibilityLoginButton();
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
