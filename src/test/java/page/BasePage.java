package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.framework.Browser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait waitDriver;

    public BasePage() {
        this.driver = Browser.getInstance().getWebDriver();
        waitDriver = new WebDriverWait(driver, 15);
    }

    public void waitVisibility(By elementBy) {
        waitDriver.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    public String getAtr(By elementBy, String atrName) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute(atrName);
    }
}
