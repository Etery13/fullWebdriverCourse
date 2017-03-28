package thetenthlesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Etery on 28.03.2017.
 */
public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CartPage open() {
        driver.get("http://localhost/litecart/en/checkout");
        return this;
    }

    @FindBy(name = "remove_cart_item")
    public WebElement removeButton;

    @FindBy(css = ".dataTable td.item")
    public List<WebElement> productsInCart;

    public int getNumberOfPoductsInCart() {
        return productsInCart.size();
    }

    public void deleteProductFromCart() {
        removeButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(new By.ByCssSelector(".dataTable td.item"), getNumberOfPoductsInCart() - 1));
    }
}
