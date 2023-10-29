import createAndDeleteWebDriver.CreateWebDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegistrationPage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;
import baseURL.BaseUrl;

public class RegistrationTest {
    WebDriver driver = CreateWebDriver.createWebDriver();
    User user;

    @Test
    public void registrationNewUserSuccess() throws InterruptedException {
        user = CreateRandomUserData.createRandomUserData();

        driver.manage().window().maximize();
        driver.get(BaseUrl.getBaseURL());
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitingForVisibilityEmailInput()
                        .clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitingForVisibilityNameInput()
                .clickInputName()
                .fillName(user.getName())
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickToRegistrationButton();
        Thread.sleep(2000);
       loginPage.waitingForVisibilityEmailInput()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword());
                loginPage.clickLoginButton();
       homePage.waitingForVisibilityPersonalAccountButton();
    }

    @Test
    public void createNewUserWithPasswordLessThanSixCharacters(){
        user = new User("Test@mail.ru", "abcde", "TestName");

        driver.manage().window().maximize();
        driver.get(BaseUrl.getBaseURL());
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitingForVisibilityEmailInput()
                .clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitingForVisibilityNameInput()
                .clickInputName()
                .fillName(user.getName())
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickToRegistrationButton()
                .waitingForVisibilityIncorrectPasswordNotification();
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
