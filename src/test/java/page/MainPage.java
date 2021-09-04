package page;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import page.framework.Browser;

public class MainPage extends BasePage {

    private Actions actions = new Actions(Browser.getInstance().getWebDriver());

    private static final String URL_SITE = "https://store.steampowered.com";
    private static final String NAVIGATOR_LOC = "//div[@id = 'genre_flyout']";
    private static final String GENRE_TAB_LOC = "//div[@id = 'genre_tab']";
    private static final String ACTION_LOC = "//a[@class='popup_menu_item' and contains(@href, 'action')]";
    private static final String LANG_LOC = "/html[@lang]";
    private static final String LANG_MENU_LOC = "//*[@id='language_pulldown']";
    private static final String ENG_LANG_LOC = "//div[@class= 'popup_body popup_menu']//a[contains(text(), 'английский')]";

    public void clickGenreTab() {
        waitVisibility(By.xpath(GENRE_TAB_LOC));
        actions.moveToElement(driver.findElement(By.xpath(GENRE_TAB_LOC))).click().perform();
    }

    public void clickActionGenre() {
        click(By.xpath(ACTION_LOC));
    }

    public void isNavigatorDisplayed() {
        isElementDisplayed(By.xpath(NAVIGATOR_LOC));
    }

    public void clickLangMenu() {
        click(By.xpath(LANG_MENU_LOC));
    }

    public void selectEngLang() {
        click(By.xpath(ENG_LANG_LOC));
    }

    public boolean isEngLang() {
        return getAtr(By.xpath(LANG_LOC), "lang").equals("en");
    }

    public static String getUrl() {
        return URL_SITE;
    }
}
