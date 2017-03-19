package thesixthlesson;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Etery on 20.03.2017.
 */
public class TheThirteenthTest extends BaseTest {
    @Test
    public void theThirteenthTask() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("http://localhost/litecart/");
        WebElement quantity = driver.findElement(By.className("quantity"));
        int quantityNumber = new Integer(quantity.getText());
        int i = 0;
        while (quantityNumber < 2) {
            quantityNumber = new Integer(driver.findElement(By.className("quantity")).getText());
            driver.findElement(By.className("product")).click();
            if (driver.findElements(By.name("options[Size]")).size() != 0) {
                Select size = new Select(driver.findElement(By.name("options[Size]")));
                size.selectByValue("small");
            }
            driver.findElement(By.name("add_cart_product")).click();
            quantity = driver.findElement(By.className("quantity"));
            wait.until(ExpectedConditions.textToBePresentInElement(quantity, String.valueOf(quantityNumber + 1)));
            driver.get("http://localhost/litecart/");
        }
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
        List<WebElement> rows = driver.findElements(By.cssSelector(".dataTable td.item"));
        int rowsNumber = rows.size();
        while (rowsNumber > 0) {
            driver.findElement(By.name("remove_cart_item")).click();
            int finalRowsNumber = rowsNumber;
            wait.until((WebDriver d) -> d.findElements(By.cssSelector(".dataTable td.item")).size() == finalRowsNumber - 1);
            rowsNumber = driver.findElements(By.cssSelector(".dataTable td.item")).size();
        }
    }
}
