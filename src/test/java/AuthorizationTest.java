import baseURL.BaseUrl;
import createAndDeleteWebDriver.CreateWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.ForgotPasswordPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;

public class AuthorizationTest {
    WebDriver driver = CreateWebDriver.createWebDriver();
    User user;

    @Before
    public void createRandomUser(){
        user = CreateRandomUserData.createRandomUserData();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        userApiMethods.sendRequestCreate();
    }

    @Test
    public void authorizationWithLoginButtonOnHomePage(){
        driver.manage().window().maximize();
        driver.get(BaseUrl.getBaseURL());
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityLoginButton()
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        homePage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void authorizationWithLoginButtonAfterClickOnPersonalAreaButton(){
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void authorizationWithLoginButtonInRegistrationForm(){
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitingForVisibilityLoginButton()
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityCreateOrderButton();
    }

    @Test
    public void authorizationWithLoginButtonInForgotPasswordPage(){
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.waitingForVisibilityLoginButton()
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton();
        HomePage homePage = new HomePage(driver);
        homePage.waitingForVisibilityCreateOrderButton();
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
