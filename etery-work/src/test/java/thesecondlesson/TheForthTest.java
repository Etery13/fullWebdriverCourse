package thesecondlesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


/**
 * Created by Etery on 27.02.2017.
 */
public class TheForthTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setDriver() {

        // System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        //driver = new ChromeDriver();
        //driver = new EdgeDriver();
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files (x86)\\Nightly\\firefox.exe")),
                new FirefoxProfile(),new DesiredCapabilities());
        wait = new WebDriverWait(driver, 10, 20);
    }

    @Test
    synchronized public void theForthTest() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        Thread.sleep(1000);
        assert driver.findElement(By.xpath("//*[contains(text(),\"You are now logged in as admin\")]")).isDisplayed();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
