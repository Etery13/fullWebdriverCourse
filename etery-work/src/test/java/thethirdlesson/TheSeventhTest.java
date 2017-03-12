package thethirdlesson;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


/**
 * Created by Etery on 02.03.2017.
 */
public class TheSeventhTest extends BaseTest {

    @Test
    public void theSeventhTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> menu = driver.findElements(By.cssSelector("ul#box-apps-menu>li"));
        for (int i = 1; i <= menu.size(); i++) {
            WebElement point = driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[" + i + "]"));
            point.click();
            Assert.assertTrue(isElementPresent(driver, By.cssSelector("h1")));
            List<WebElement> sublist = driver.findElements(By.cssSelector("ul.docs>li"));
            for (int j = 1; j <= sublist.size(); j++) {
                WebElement subPoint = driver.findElement(By.xpath("//ul[@class='docs']/li[" + j + "]"));
                subPoint.click();
                Assert.assertTrue(isElementPresent(driver, By.cssSelector("h1")));
            }
        }
    }

}
