package theforthlesson;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Etery on 13.03.2017.
 */
public class TheNinthTest extends BaseTest {

    @Test
    public void theNinthTest() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> rows = driver.findElements(By.cssSelector(".dataTable .row"));
        List<String> listOfCountries = new LinkedList<>();
        for (int i = 1; i <= rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("(//table[@class='dataTable']//tr[@class='row'])[" + i + "]"));
            WebElement country = row.findElement(By.xpath("(.//td)[5]"));
            Integer numberOfTimeZones = Integer.valueOf(row.findElement(By.xpath("(.//td)[6]")).getText());
            listOfCountries.add(country.getText());
            if (numberOfTimeZones > 0) {
                List<String> listOfZones = new LinkedList<>();
                country.findElement(By.cssSelector("a")).click();
                List<WebElement> zones = driver.findElements(By.xpath("//table[@id='table-zones']//tr[td[1][.//input[@type='hidden']]]"));
                for (WebElement zone : zones) {
                    zone.findElement(By.xpath(".//td[3]")).getAttribute("value");
                }
                Assert.assertTrue(isListSorted(listOfZones));
                driver.navigate().back();
            }
        }
        Assert.assertTrue(isListSorted(listOfCountries));
    }
}
