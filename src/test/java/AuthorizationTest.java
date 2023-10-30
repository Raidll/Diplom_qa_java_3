import baseurl.BaseUrl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.ForgotPasswordPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;
import user.UserEmailAndNameModel;

public class AuthorizationTest {
    DriverFactory driverFactory = new DriverFactory();
    User user;

    public AuthorizationTest() throws InterruptedException {
    }

    @Before
    public void createRandomUser(){
        user = CreateRandomUserData.createRandomUserData();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        userApiMethods.sendRequestCreate();
    }

    @Test
    public void authorizationWithLoginButtonOnHomePage(){
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get(BaseUrl.getBaseURL());
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityLoginButton()
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        homePage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void authorizationWithLoginButtonAfterClickOnPersonalAreaButton(){
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void authorizationWithLoginButtonInRegistrationForm(){
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driverFactory.getDriver());
        registrationPage.waitingForVisibilityLoginButton()
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void authorizationWithLoginButtonInForgotPasswordPage(){
        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverFactory.getDriver());
        forgotPasswordPage.waitingForVisibilityLoginButton()
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.waitingForVisibilityCreateOrderButton();
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
