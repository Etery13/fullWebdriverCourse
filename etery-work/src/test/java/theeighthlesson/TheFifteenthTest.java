package theeighthlesson;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Etery on 23.03.2017.
 */
public class TheFifteenthTest {

    @Test
    public void remote() throws MalformedURLException, InterruptedException {
        //DesiredCapabilities capabilities=new DesiredCapabilities();
       // capabilities.setBrowserName("internetexplorer");
        RemoteWebDriver driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.internetExplorer());
        driver.get("http://yandex.ru");
        Thread.sleep(10000);
        driver.quit();
        driver=null;
    }
}