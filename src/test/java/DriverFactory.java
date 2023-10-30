import config.EnvConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    WebDriver driver;
    Long duration = 3L;

    public DriverFactory() throws InterruptedException {
        if ("yandex".equals(System.getProperty("browser")))
            setUpYandex();
        else
            driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void setUpYandex() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver116.exe");
        options.addArguments("--remote-allow-origins=*");
        options.setBinary(EnvConfig.PATH_BROWSER_YANDEX_EXE);
        driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void killDriver() {
        driver.quit();
    }

}
