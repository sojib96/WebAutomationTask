package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class CartPage extends BasePage {
    private final By productsTitle = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fetching the list of product titles in the cart to verify with the product titles on the product page")
    public List<String> getProductsTitle() {
        return getElementsText(productsTitle);
    }

    @Step("Clicking the 'Checkout' button to proceed to the checkout page")
    public void clickCheckoutButton() {
        clickElement(checkoutButton);
    }
}
