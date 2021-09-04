package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import page.MainPage;

public class BaseSteps {

    private MainPage mainPage = new MainPage();

    @Given("Open the page {string}")
    public void openPage(String url) {
        Selenide.open(MainPage.getUrl());
    }
}
