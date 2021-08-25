package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.MainPage;
import page.framework.Browser;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        Browser browser = Browser.getInstance();
        browser.open(MainPage.getUrl());
    }

    @AfterEach
    public void tearDown() {
        Browser.getInstance().quit();
    }
}
