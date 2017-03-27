package theninthlesson;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Etery on 26.03.2017.
 */
public class TheSeventeenthTest {
    WebDriver driver;
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void browserLogs() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        int numberOfProducts = driver.findElements(By.xpath("//td[./img]/a")).size();
        for (int i = 1; i <= numberOfProducts; i++) {
            driver.findElement(By.xpath("(//td[./img]/a)[" + i + "]")).click();
            try {
                Assert.assertEquals(0, driver.manage().logs().get("browser").getAll().size());
            } catch (Throwable t) {
                collector.addError(t);
            }
            driver.navigate().back();
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
