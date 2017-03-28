package thetenthlesson.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import thetenthlesson.pages.CartPage;
import thetenthlesson.pages.CatalogPage;
import thetenthlesson.pages.ProductPage;

/**
 * Created by Etery on 28.03.2017.
 */
public class Application {

    private WebDriver driver;
    private CartPage cartPage;
    private CatalogPage catalogPage;
    private ProductPage productPage;

    public Application() {
        driver = new ChromeDriver();
        cartPage = new CartPage(driver);
        catalogPage = new CatalogPage(driver);
        productPage = new ProductPage(driver);
    }

    public int getQuantity() {
        return catalogPage.open().getQuantity();
    }

    public void addThreeProductsToCart() {
        catalogPage.open();
        while (catalogPage.getQuantity() <= 2) {
            catalogPage.product.click();
            productPage.addProductToCart();
        }
    }

    public void deleteProductsFromCart() {
        cartPage.open();
        while (cartPage.getNumberOfPoductsInCart() > 0) {
            cartPage.deleteProductFromCart();
        }
    }

    public void quit() {
        driver.quit();
    }

}
