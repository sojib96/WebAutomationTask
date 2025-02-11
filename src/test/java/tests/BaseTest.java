package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;


public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutSummaryPage checkoutSummaryPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void setUp() {
        driver = utils.DriverManager.getDriver();
        driver.get(utils.SettingsTestData.getEnvData().getHost());

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutSummaryPage = new CheckoutSummaryPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        utils.DriverManager.quitDriver();
    }
}
