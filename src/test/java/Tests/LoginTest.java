package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/");
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        String expectedURL = "https://www.saucedemo.com/v1/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(productsPage.pageTitle.isDisplayed());
        Assert.assertTrue(productsPage.pageLogo.isDisplayed());
        Assert.assertTrue(productsPage.shoppingCart.isDisplayed());

    }

    @Test(priority = 20)
    public void loginWithInvalidUsername() {

        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUsername = excelReader.getStringData("Sheet1", i, 0);

            loginPage.enterUsername(invalidUsername);
            loginPage.enterPassword(validPassword);
            loginPage.clickOnLoginButton();

            String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
            Assert.assertTrue(loginPage.error.isDisplayed());
            Assert.assertEquals(loginPage.errorMessage.getText(), expectedErrorMessage);
        }

    }

    @Test(priority = 30)
    public void loginWithInvalidPassword() {

        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidPassword = excelReader.getStringData("Sheet1", i, 1);

            loginPage.enterUsername(validUsername);
            loginPage.enterPassword(invalidPassword);
            loginPage.clickOnLoginButton();

            String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
            Assert.assertTrue(loginPage.error.isDisplayed());
            Assert.assertEquals(loginPage.errorMessage.getText(), expectedErrorMessage);
        }

    }

    @Test(priority = 40)
    public void usernameFieldEmpty() {
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertTrue(loginPage.error.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), expectedErrorMessage);

    }

    @Test(priority = 50)
    public void passwordFieldEmpty() {
        loginPage.enterUsername(validUsername);
        loginPage.clickOnLoginButton();

        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertTrue(loginPage.error.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), expectedErrorMessage);

    }


}
