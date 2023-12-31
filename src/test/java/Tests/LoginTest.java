package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");
    }

    @Test
    public void userCanLogIn() {
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(productsPage.pageTitle.isDisplayed());
        Assert.assertTrue(productsPage.pageLogo.isDisplayed());
        Assert.assertTrue(productsPage.shoppingCartIcon.isDisplayed());

    }

    @Test(priority = 10)
    public void loginWithInvalidUsername() {

        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUsername = excelReader.getStringData("Sheet1", i, 0);

            loginPage.enterUsername(invalidUsername);
            loginPage.enterPassword(validPassword);
            loginPage.clickOnLoginButton();

            Assert.assertTrue(loginPage.error.isDisplayed());
            Assert.assertEquals(loginPage.errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
        }

    }

    @Test(priority = 20)
    public void loginWithInvalidPassword() {

        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidPassword = excelReader.getStringData("Sheet1", i, 1);

            loginPage.enterUsername(validUsername);
            loginPage.enterPassword(invalidPassword);
            loginPage.clickOnLoginButton();

            Assert.assertTrue(loginPage.error.isDisplayed());
            Assert.assertEquals(loginPage.errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");
        }

    }

    @Test(priority = 30)
    public void usernameFieldEmpty() {
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.error.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), "Epic sadface: Username is required");

    }

    @Test(priority = 40)
    public void passwordFieldEmpty() {
        loginPage.enterUsername(validUsername);
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.error.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), "Epic sadface: Password is required");

    }

}
