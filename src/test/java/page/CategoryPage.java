package page;

import org.openqa.selenium.By;


public class CategoryPage extends BasePage {

    private static final String ACTION_HEADER_LOC = "//*[@class='pageheader' and contains(text(), 'Action')]";
    private static final String FIRST_GAME_IN_SLIDE_LOC = "//div[@class = 'carousel_thumbs']/div[1]";
    private static final String GAME_LOC ="//*[@id='genre_large_cluster']/div[1]";
    private static final String GAME_PRICE_LOC = "(//div[contains(@class, 'discount_block ')])[1]";

    public void isCategoryNameHeaderDisplayed() {
        isElementDisplayed(By.xpath(ACTION_HEADER_LOC));
    }

    public void clickToFirstGameInSlide() {
        click(By.xpath(FIRST_GAME_IN_SLIDE_LOC));
    }

    public void clickToGame() {
        click(By.xpath(GAME_LOC));
    }

    public String getPriceOnCategoryPage() {
        return getAtr(By.xpath(GAME_PRICE_LOC), "data-price-final");
    }
}
