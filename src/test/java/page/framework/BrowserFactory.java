package page.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFirefoxDriver();
            default:
                return getChromeDriver();
        }
    }

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\resources\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");

        return new ChromeDriver(chromeOptions);
    }

    private WebDriver getFirefoxDriver() {
        return null;
    }
}
