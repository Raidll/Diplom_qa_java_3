import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;
import user.UserEmailAndNameModel;

public class PersonalAccountTest {
    DriverFactory driverFactory = new DriverFactory();
    User user;

    public PersonalAccountTest() throws InterruptedException {
    }

    @Before
    public void createRandomUser(){
        user = CreateRandomUserData.createRandomUserData();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        userApiMethods.sendRequestCreate();
    }

    @Test
    public void goToPersonalAccount(){
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driverFactory.getDriver());
        profilePage.waitingForVisibilitySaveButton();
    }

    @Test
    public void goToConstructorTest() {
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driverFactory.getDriver());
        profilePage.waitingForVisibilityConstructorButton()
                .clickConstructorButton();
        ConstructorPage constructorPage = new ConstructorPage(driverFactory.getDriver());
        constructorPage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void goToConstructorClickOnLogo() {
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driverFactory.getDriver());
        profilePage.waitingForVisibilityLogoButton()
                .clickLogoButton();
        ConstructorPage constructorPage = new ConstructorPage(driverFactory.getDriver());
        constructorPage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void logoutButtonTest() {
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driverFactory.getDriver());
        profilePage.waitingForVisibilityLogoutButton()
                .clickLogoutButton();
        homePage.waitingForVisibilityPersonalAccountButton()
                .clickButtonPersonalAccount();
        loginPage.waitingForVisibilityLoginButton();
    }

    @After
    public void teardown() {
        driverFactory.getDriver().quit();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        if (userApiMethods.isUserExist(new UserEmailAndNameModel(user.getEmail(), user.getName()))) {
            userApiMethods.sendRequestLogin(new UserEmailAndNameModel(user.getEmail(), user.getName()));
            userApiMethods.sendRequestDelete(user);
        }
    }
}
