package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.*;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private static final Duration DEFAULT_WAIT_TIME_SECONDS = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME_SECONDS);
    }

    protected WebElement waitForElement(By locator) {
        LoggerUtility.info("Waiting for element: " + locator.toString());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> waitForElements(By locator) {
        LoggerUtility.info("Waiting for elements: " + locator.toString());
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void clickElement(By locator) {
        waitForElement(locator).click();
        LoggerUtility.info("Clicking element: " + locator.toString());
    }

    protected void clickElements(By locator, int count) {
        LoggerUtility.info("Attempting to add/remove " + count + " products to/from the cart.");
        List<WebElement> addOrRemoveButtons = waitForElements(locator);
        for (int i = 0; i < count; i++) {
            addOrRemoveButtons.get(i).click();
            LoggerUtility.info("Clicked element " + (i + 1));
        }
        LoggerUtility.info("Completed adding/removing products.");
    }

    protected void enterText(By locator, String text) {
        waitForElement(locator).sendKeys(text);
        LoggerUtility.info("Entering text in element: " + locator.toString() + " | Text: " + text);
    }

    protected List<String> getElementsText(By locator) {
        List<WebElement> elements = waitForElements(locator);
        LoggerUtility.info("Fetching text from elements: " + locator.toString());
        return elements.stream().map(WebElement::getText).toList();
    }

    protected void selectSortingOption(By locator, String optionValue) {
        Select dropdown = new Select(waitForElement(locator));
        LoggerUtility.info("Selecting dropdown option: " + optionValue + " from " + locator.toString());
        dropdown.selectByVisibleText(optionValue);
    }
}
