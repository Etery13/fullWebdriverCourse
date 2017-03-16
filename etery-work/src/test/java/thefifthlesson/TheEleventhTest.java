package thefifthlesson;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;


/**
 * Created by Etery on 16.03.2017.
 */
public class TheEleventhTest extends BaseTest {

    @Test
    public void registration() throws InterruptedException {
        String email = UUID.randomUUID().toString() + "@gmail.com";
        String password = "testtest1";
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector("[name=login_form] a")).click();
        driver.findElement(By.name("firstname")).sendKeys("First Name");
        driver.findElement(By.name("lastname")).sendKeys("Last Name");
        driver.findElement(By.name("address1")).sendKeys("Address 1");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("City");
        Select country = new Select(driver.findElement(By.name("country_code")));
        country.selectByVisibleText("United States");
        Select zoneCode = new Select(driver.findElement(By.cssSelector("select[name=zone_code]")));
        zoneCode.selectByIndex(zoneCode.getOptions().size() * (int) Math.random());
        driver.findElement(By.name("email")).sendKeys(email);
        WebElement phone = driver.findElement(By.name("phone"));
        phone.click();
        phone.sendKeys(Keys.HOME + "+79111111111");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[text()='Logout']"));
    }
}
