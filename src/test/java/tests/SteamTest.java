package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.CategoryPage;
import page.GamePage;
import page.MainPage;

public class SteamTest extends BaseTest {

    @Test
    public void checkGamePriceOnCategoryPageAndGamePage() {
        MainPage mainPage = new MainPage();
        if (!mainPage.isEngLang()) {
            mainPage.clickLangMenu();
            mainPage.selectEngLang();
        }
        mainPage.clickGenreTab();
        mainPage.clickGenreTab();
        mainPage.isNavigatorDisplayed();
        mainPage.clickActionGenre();
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.isCategoryNameHeaderDisplayed();
        categoryPage.clickToFirstGameInSlide();
        String expectedPrice = categoryPage.getPriceOnCategoryPage();
        categoryPage.clickToGame();
        GamePage gamePage = new GamePage();
        Assertions.assertEquals(expectedPrice, gamePage.getGamePriceInGamePage());
    }


}
