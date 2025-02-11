package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CheckoutSummaryPage extends BasePage {
    private final By productsTitle = By.className("inventory_item_name");
    private final By finishBtn = By.id("finish");

    public CheckoutSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fetching the list of product titles displayed on the summary page to matching with the product titles on the product page")
    public List<String> getProductsTitle() {
        return getElementsText(productsTitle);
    }

    @Step("Clicking the 'Finish' button to complete the checkout process")
    public void clickFinishButton() {
        clickElement(finishBtn);
    }
}
