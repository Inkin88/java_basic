package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import page.MainPage;


public class MainPageSteps {

    private MainPage mainPage = new MainPage();


    @And("Check that page on English lang")
    public void checkSiteLang() {
        if (!mainPage.isEngLang()) {
            mainPage.clickLangMenu();
            mainPage.selectEngLang();
        }
    }
    @When("Go to the specific genre page")
    public void goToSpecificGenre() {
        mainPage.clickGenreTab();
        mainPage.clickGenreTab();
        mainPage.isNavigatorDisplayed();
        mainPage.clickActionGenre();
    }

}
