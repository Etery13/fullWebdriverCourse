package theforthlesson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Etery on 13.03.2017.
 */
public class BaseTest {
    WebDriver driver;


    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


    static boolean isListSorted(List list){
        ArrayList sortedList=new ArrayList();
        sortedList.addAll(list);
        Collections.sort(sortedList);
        try {
            Assert.assertEquals(list,sortedList);
            return true;
        }
        catch (AssertionError er){
            return false;
        }
    }
}