package thetenthlesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Etery on 28.03.2017.
 */
public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "options[Size]")
    WebElement size;

    @FindBy(name = "add_cart_product")
    WebElement addProductButton;

    public void selectSize(String value) {
        new Select(size).selectByValue(value);
    }

    public CatalogPage addProductToCart() {
        int quantityNumber = new Integer(driver.findElement(By.className("quantity")).getText());
        if (isElementPresent(driver, new By.ByName("options[Size]"))) {
            selectSize("Small");
        }
        addProductButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(quantity, String.valueOf(quantityNumber + 1)));
        driver.navigate().back();
        return new CatalogPage(driver);
    }
}
