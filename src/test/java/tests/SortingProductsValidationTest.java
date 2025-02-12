package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SortingProductsValidationTest extends BaseTest{

    @Test
    public void test() {
        login(utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());

        productPage.sortProductsByOption("Price (low to high)");
        List<Double> pricesLowToHigh = productPage.getProductPrices();
        Assert.assertEquals(pricesLowToHigh,
                utils.SortingUtils.getExpectedSortedList(pricesLowToHigh, false),
                "Prices not sorted Low-High");

        productPage.sortProductsByOption("Price (high to low)");
        List<Double> pricesHighToLow = productPage.getProductPrices();
        Assert.assertEquals(pricesHighToLow,
                utils.SortingUtils.getExpectedSortedList(pricesHighToLow, true),
                "Prices not sorted High-Low");

        productPage.sortProductsByOption("Name (A to Z)");
        List<String> namesAToZ = productPage.getProductsTitle();
        Assert.assertEquals(namesAToZ,
                utils.SortingUtils.getExpectedSortedList(namesAToZ, false),
                "Names not sorted A-Z");

        productPage.sortProductsByOption("Name (Z to A)");
        List<String> namesZToA = productPage.getProductsTitle();
        Assert.assertEquals(namesZToA,
                utils.SortingUtils.getExpectedSortedList(namesZToA, true),
                "Names not sorted Z-A");
    }
}
