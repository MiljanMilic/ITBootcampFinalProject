package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductsPage extends BaseTest {
    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "product_label")
    public WebElement pageTitle;
    @FindBy(className = "app_logo")
    public WebElement pageLogo;
    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCart;

    //---------------------

}
