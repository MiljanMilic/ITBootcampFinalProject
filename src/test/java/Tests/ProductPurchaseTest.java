package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseTest extends BaseTest{

    @BeforeMethod
    public void pageSetUp(){
        homePage();
    }

    @Test
    public void purchaseSingleProduct() {
        productsPage.clickOnAddToCartButton();
        productsPage.clickOnShoppingCartButton();
        cartPage.clickOnCheckoutButton();
        checkoutInfoPage.inputFirstName("Pera");
        checkoutInfoPage.inputLastName("Peric");
        checkoutInfoPage.inputPostalCode("11000");
        checkoutInfoPage.clickOnContinueButton();
        checkoutOverviewPage.clickOnFinishButton();
        String expectedMessage = "Thank you for your order!";
        Assert.assertTrue(checkoutCompletePage.completeMessage.isDisplayed());
        Assert.assertEquals(checkoutCompletePage.completeMessage.getText(), expectedMessage);
        Assert.assertTrue(checkoutCompletePage.backHomeButton.isDisplayed());

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
