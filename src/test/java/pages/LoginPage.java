package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering username: {0} into the username field")
    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    @Step("Entering password: {0} into the password field")
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    @Step("Clicking on the Login button to attempt authentication")
    public void clickLoginButton() {
        clickElement(loginButton);
    }

    @Step("Checking if an error message is displayed on the login page for invalid login details")
    public boolean isErrorMessageDisplayed() {
        return waitForElement(errorMessage).isDisplayed();
    }

    @Step("Verifying successful logout by checking if the login page is displayed with the login button")
    public boolean isLoginPageDisplayed() {
        return waitForElement(loginButton).isDisplayed();
    }

    @Step("Fetching the error message text displayed on the login page to verify locked out user")
    public String getErrorMessage() {
        return waitForElement(errorMessage).getText();
    }
}
