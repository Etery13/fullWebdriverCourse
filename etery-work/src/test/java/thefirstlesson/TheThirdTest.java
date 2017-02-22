package thefirstlesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Etery on 22.02.2017.
 */
public class TheThirdTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait= new WebDriverWait(driver,10,2);
    }

    @Test
    synchronized public void theThirdTest() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        Thread.sleep(100);

        assert driver.findElement(By.xpath("//*[contains(text(),\"You are now logged in as admin\")]")).isDisplayed();
    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
