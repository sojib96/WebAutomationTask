package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private final By successMessage = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Fetching the success message displayed on the checkout complete page to verify the successful completion of the order")
    public String getSuccessMessage() {
        return waitForElement(successMessage).getText();
    }
}
