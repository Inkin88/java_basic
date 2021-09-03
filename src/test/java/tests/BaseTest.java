package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.MainPage;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        Selenide.open(MainPage.getUrl());
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
