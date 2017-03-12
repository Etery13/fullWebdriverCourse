package thethirdlesson;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Created by Etery on 13.03.2017.
 */
public class TheEighthTest extends BaseTest {

    @Test
    public void theEighthTest() {
        driver.get("http://localhost/litecart/");
        List<WebElement> ducks=driver.findElements(By.cssSelector(".product"));
        for (WebElement duck: ducks) {
            List<WebElement> stickers=duck.findElements(By.cssSelector(".sticker"));
            Assert.assertEquals(1,stickers.size());
        }
    }
}
