package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductPage extends BasePage {
    private final By pageTitle = By.className("title");
    private final By productsTitle = By.className("inventory_item_name");
    private final By addToCartOrRemoveButtons = By.className("btn_inventory");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By hamburgerMenu = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By sortDropdown = By.className("product_sort_container");
    private final By productPrices = By.className("inventory_item_price");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fetching the title of the product page to verify successful login")
    public String getPageTitle() {
        return waitForElement(pageTitle).getText();
    }

    @Step("Fetching the list of product titles displayed on the Product page to verify")
    public List<String> getProductsTitle() {
        return getElementsText(productsTitle);
    }

    public void addProductsToCartOrRemove(int count, boolean isAdding) {
        String action = isAdding ? "Adding" : "Removing";
        Allure.step(action + " first " + count + " products to the cart");
        clickElements(addToCartOrRemoveButtons, count);
    }

    @Step("Clicking on the cart icon to navigate to the cart page")
    public void clickCartIcon() {
        clickElement(cartIcon);
    }

    @Step("Clicking on the hamburger menu to open navigation options")
    public void clickHamburgerMenu() {
        clickElement(hamburgerMenu);
    }

    @Step("Clicking on the Logout button to log out of the application")
    public void clickLogoutButton() {
        clickElement(logoutButton);
    }

    @Step("Fetching the current cart badge count displayed on the cart icon to verify")
    public String getCartBadgeCount() {
        return waitForElement(cartIcon).getText();
    }

    @Step("Sorting products using the option: {0}")
    public void sortProductsByOption(String optionValue) {
        selectSortingOption(sortDropdown, optionValue);
    }

    @Step("Fetching and converting the list of product prices to double values for verifying expected sorting")
    public List<Double> getProductPrices() {
        return utils.DataUtils.convertPricesToDouble(getElementsText(productPrices));
    }
}
