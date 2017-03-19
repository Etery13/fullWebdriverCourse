package thefifthlesson;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

/**
 * Created by Etery on 19.03.2017.
 */
public class TheTwelfthTest  extends BaseTest {

    @Test
    public void TheTwelfthTask(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//span[text()='Catalog']")).click();
        driver.findElement(By.xpath("//a[text()=' Add New Product']")).click();
        driver.findElement(By.xpath("//input[@value=1 and @name='status']")).click();
        driver.findElement(By.name("name[en]")).sendKeys("Elizabeth");
        driver.findElement(By.name("code")).sendKeys("Eli");
        driver.findElement(By.xpath("//input[@name='product_groups[]' and @value='1-3']")).click();
        driver.findElement(By.name("quantity")).sendKeys(Keys.HOME+"13");
        driver.findElement(By.name("new_images[]")).sendKeys(System.getProperty("user.dir") +"/src/test/resources/elizabeth.jpeg");
        driver.findElement(By.name("date_valid_from")).sendKeys(Keys.HOME+"01/03/2017");
        driver.findElement(By.name("date_valid_to")).sendKeys(Keys.HOME+"01/04/2017");
        driver.findElement(By.xpath("//a[text()='Information']")).click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("keywords")));
        Select manufacturer=new Select(driver.findElement(By.name("manufacturer_id")));
        manufacturer.selectByValue("1");
        driver.findElement(By.name("keywords")).sendKeys("gintama, elizabeth");
        driver.findElement(By.name("short_description[en]")).sendKeys("Katsura's unusual pet Amanto and a member of the Jouishishi.");
        String str="After being abducted and turned into a Renho he adopts the name of General Eren of the Renho race, a race of mercenaries specialized in covert operations, and he, along with many Renho, act as pets for numerous Earthlings in order to prepare Earth for an invasion. It's very likely that this Elizabeth was given to Katsura by Sakamoto Tatsuma since he was the one who brought all the Renho to earth.\n" +
                "Eren replaces regular Elizabeth on Monday, Eren would watch television with Katsura and reinact commerical songs. Eren plays Uno with Katsura a lot, although he's bad at it. Eren would let Katsura win a few times.\n" +
                "Eren was in a relationship with Fumiko before she defected the Renho. It is possible that eren's actions will be attributed to the normal elizabeth, who is currently the only elizabeth, later in the series because the writer may forget the joke, as such the joke and the \"monday elizabeth\" in its entirety may become non-canon.";
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        driver.findElement(By.className("trumbowyg-editor")).sendKeys(Keys.CONTROL+"v");
        driver.findElement(By.name("head_title[en]")).sendKeys("Elizabeth");
        driver.findElement(By.name("meta_description[en]")).sendKeys("Elizabeth");
        driver.findElement(By.xpath("//a[text()='Prices']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("purchase_price")));
        driver.findElement(By.name("purchase_price")).sendKeys(Keys.HOME+"1");
        Select currency=new Select(driver.findElement(By.name("purchase_price_currency_code")));
        currency.selectByValue("EUR");
        driver.findElement(By.name("prices[USD]")).sendKeys(Keys.HOME+"2");
        driver.findElement(By.name("prices[EUR]")).sendKeys(Keys.HOME+"3");
        driver.findElement(By.name("save")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Elizabeth')]")).isDisplayed());
    }
}
