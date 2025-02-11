package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering first name: {0} into first name field")
    public void enterFirstName(String firstName) {
        enterText(firstNameField, firstName);
    }

    @Step("Entering last name: {0} into last name field")
    public void enterLastName(String lastName) {
        enterText(lastNameField, lastName);
    }

    @Step("Entering postal code: {0} into postal code field")
    public void enterPostalCode(String postalCode) {
        enterText(postalCodeField, postalCode);
    }

    @Step("Clicking the 'Continue' button to proceed to checkout summary")
    public void clickContinueButton() {
        clickElement(continueButton);
    }
}
