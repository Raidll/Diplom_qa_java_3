import org.junit.After;
import org.junit.Test;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import user.CreateRandomUserData;
import user.User;
import user.UserApiMethods;
import baseurl.BaseUrl;
import user.UserEmailAndNameModel;

public class RegistrationTest {
    DriverFactory driverFactory = new DriverFactory();
    User user;

    public RegistrationTest() throws InterruptedException {
    }

    @Test
    public void registrationNewUserSuccess() throws InterruptedException {
        user = CreateRandomUserData.createRandomUserData();

        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get(BaseUrl.getBaseURL());
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.waitingForVisibilityEmailInput()
                        .clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driverFactory.getDriver());
        registrationPage.waitingForVisibilityNameInput()
                .clickInputName()
                .fillName(user.getName())
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickToRegistrationButton();
       loginPage.waitingForVisibilityEmailInput()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword());
                loginPage.clickLoginButton();
       homePage.waitingForVisibilityPersonalAccountButton();
    }

    @Test
    public void createNewUserWithPasswordLessThanSixCharacters(){
        user = new User("Test@mail.ru", "abcde", "TestName");

        driverFactory.getDriver().manage().window().maximize();
        driverFactory.getDriver().get(BaseUrl.getBaseURL());
        HomePage homePage = new HomePage(driverFactory.getDriver());
        homePage.clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driverFactory.getDriver());
        loginPage.waitingForVisibilityEmailInput()
                .clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driverFactory.getDriver());
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
        driverFactory.getDriver().quit();
        UserApiMethods userApiMethods = new UserApiMethods(user);
        if (userApiMethods.isUserExist(new UserEmailAndNameModel(user.getEmail(), user.getName()))) {
            userApiMethods.sendRequestLogin(new UserEmailAndNameModel(user.getEmail(), user.getName()));
            userApiMethods.sendRequestDelete(user);
        }
    }
}
