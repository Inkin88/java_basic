package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

public class SeleniumTest {
    private WebDriver webDriver;
    private static final String TEST_URL = "http://automationpractice.com/index.php";
    private static final String WOMEN_BUTTON_LOC = "//div[@id = 'block_top_menu']//a[@title = 'Women']";
    private static final String DRESSES_BUTTON_LOC = "(//a[@title = 'Dresses'])[2]";
    private static final String T_SHIRTS_BUTTON_LOC = "(//a[@title = 'T-shirts'])[2]";
    private static final String UNIVERSAL_TITLE_LOC = "//span[@class = 'cat-name']";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(TEST_URL);
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void goToCategoriesOfTopMenu(String button, String title, String text) {
        WebElement element = webDriver.findElement(By.xpath(button));
        element.click();
        WebElement webTitle = webDriver.findElement(By.xpath(title));
        String titleName = webTitle.getText();
        Assertions.assertTrue(titleName.toLowerCase().contains(text));
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(WOMEN_BUTTON_LOC, UNIVERSAL_TITLE_LOC, "women"),
                Arguments.of(DRESSES_BUTTON_LOC, UNIVERSAL_TITLE_LOC, "dresses"),
                Arguments.of(T_SHIRTS_BUTTON_LOC, UNIVERSAL_TITLE_LOC, "t-shirts")
        );
    }
}
