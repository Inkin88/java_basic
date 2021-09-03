package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class CategoryPage {

    SelenideElement actionHeader = $x("//*[@class='pageheader' and contains(text(), 'Action')]");
    SelenideElement firstGameInSlide = $x("//div[@class = 'carousel_thumbs']/div[1]");
    SelenideElement game = $x("//*[@id='genre_large_cluster']/div[1]");
    SelenideElement gamePrice = $x("(//div[contains(@class, 'discount_block ')])[1]");

    public void isCategoryNameHeaderDisplayed() {
        actionHeader.shouldBe(Condition.visible);
    }

    public void clickToFirstGameInSlide() {
        firstGameInSlide.click();
    }

    public void clickToGame() {
        game.click();
    }

    public String getPriceOnCategoryPage() {
        return gamePrice.getAttribute("data-price-final");
    }
}
