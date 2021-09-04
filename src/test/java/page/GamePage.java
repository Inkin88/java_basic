package page;

import org.openqa.selenium.By;

public class GamePage extends BasePage {

    private static final String GAME_PRICE_IN_GAME_PAGE = "//div[@class ='game_area_purchase_game']//div[@data-price-final]";

    public String getGamePriceInGamePage() {
        return getAtr(By.xpath(GAME_PRICE_IN_GAME_PAGE), "data-price-final");
    }
}
