package steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import page.GamePage;

public class GamePageSteps {

    GamePage gamePage = new GamePage();

    @Then("Check that game price on genre page equals game price in game page")
    public void checkGamePrice() {
        Assertions.assertEquals(CategoryPageSteps.categoryPageContainer.get("gamePriceOnCategoryPage")
                , gamePage.getGamePriceInGamePage());
    }
}
