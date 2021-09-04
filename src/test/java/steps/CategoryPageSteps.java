package steps;

import io.cucumber.java.en.And;
import page.CategoryPage;

import java.util.HashMap;
import java.util.Map;

public class CategoryPageSteps {

    private CategoryPage categoryPage = new CategoryPage();

    public static Map<String, String> categoryPageContainer = new HashMap<>();

    @And("Click to the first game on slide")
    public void clickToTheFirstGameOnSlide() {
        categoryPage.isCategoryNameHeaderDisplayed();
        categoryPage.clickToFirstGameInSlide();
        categoryPageContainer.put("gamePriceOnCategoryPage", categoryPage.getPriceOnCategoryPage());
        categoryPage.clickToGame();
    }
}
