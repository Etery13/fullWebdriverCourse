package thefifthlesson;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Etery on 13.03.2017.
 */
public class BaseTest {
    WebDriver driver;

    @Before
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}