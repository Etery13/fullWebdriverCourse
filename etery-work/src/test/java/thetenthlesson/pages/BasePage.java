package thetenthlesson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Etery on 28.03.2017.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @FindBy(className = "quantity ")
    public WebElement quantity;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    public WebElement checkout;

    public int getQuantity() {
        return new Integer(quantity.getText());
    }

    public CartPage openCartPage() {
        checkout.click();
        return new CartPage(driver);
    }

}
