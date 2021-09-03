package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class MainPage {

    SelenideElement genreTab = $x("//div[@id = 'genre_tab']");
    SelenideElement actionGenre = $x("//a[@class='popup_menu_item' and contains(@href, 'action')]");
    SelenideElement navigator = $x("//div[@id = 'genre_flyout']");
    SelenideElement langMenu = $x("//*[@id='language_pulldown']");
    SelenideElement engLang = $x("//div[@class= 'popup_body popup_menu']//a[contains(text(), 'английский')]");
    SelenideElement lang = $x("/html[@lang]");

    private static final String URL_SITE = "https://store.steampowered.com";

    public void clickGenreTab() {
        actions().moveToElement(genreTab).click(genreTab).perform();
    }

    public void clickActionGenre() {
        actionGenre.click();
    }

    public void isNavigatorDisplayed() {
        navigator.shouldBe(Condition.visible);
    }

    public void clickLangMenu() {
        langMenu.click();
    }

    public void selectEngLang() {
        engLang.click();
    }

    public boolean isEngLang() {
       return lang.getAttribute("lang").equals("en");
    }

    public static String getUrl() {
        return URL_SITE;
    }
}
