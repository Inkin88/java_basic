package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GamePage {

    SelenideElement gamePriceInGamePage = $x("//div[@class ='game_area_purchase_game']//div[@data-price-final]");

    public String getGamePriceInGamePage() {
        return gamePriceInGamePage.getAttribute("data-price-final");
    }
}
