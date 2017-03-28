package thetenthlesson.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Etery on 28.03.2017.
 */
public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CatalogPage open() {
        driver.get("http://localhost/litecart/");
        return this;
    }

    @FindBy(className = "product")
    public WebElement product;


}
