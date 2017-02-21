package thefirstlesson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Etery on 22.02.2017.
 */
public class TheFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait= new WebDriverWait(driver,10,2);
    }

    @Test
    public void theFirstTest(){
        driver.get("https://www.yandex.ru");
    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
