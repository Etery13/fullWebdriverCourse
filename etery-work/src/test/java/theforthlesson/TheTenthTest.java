package theforthlesson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Etery on 14.03.2017.
 */

@RunWith(Parameterized.class)
public class TheTenthTest {
    private WebDriver driver;
    private String browser;

    public TheTenthTest(String browser){
        this.browser=browser;
    }
    @Parameterized.Parameters
    public static Iterable<? extends Object> data() {
        return  Arrays.asList("chrome", "edge", "firefox");
    }

    @Before
    public void setDriver() {
        if ("chrome".equals(browser)){
        driver = new ChromeDriver();
        } else if ("edge".equals(browser)){
            driver=new EdgeDriver();
        } else {
            driver= new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void verifyName() {
        driver.get("http://localhost/litecart");
        WebElement campaignsProduct = driver.findElement(By.cssSelector("#box-campaigns .product"));
        String name = campaignsProduct.findElement(By.className("name")).getText();
        campaignsProduct.findElement(By.cssSelector("a")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).getText().equals(name));
    }

    @Test
    public void verifyPrices() {
        driver.get("http://localhost/litecart");
        WebElement campaignsProduct = driver.findElement(By.cssSelector("#box-campaigns .product"));
        String regularPrice = campaignsProduct.findElement(By.className("regular-price")).getText();
        String campaignPrice = campaignsProduct.findElement(By.className("campaign-price")).getText();
        campaignsProduct.findElement(By.cssSelector("a")).click();
        Assert.assertTrue(driver.findElement(By.className("regular-price")).getText().equals(regularPrice));
        Assert.assertTrue(driver.findElement(By.className("campaign-price")).getText().equals(campaignPrice));
    }

    @Test
    public void verifyThatRegularPriceIsGreyAndStrikeout() {
        driver.get("http://localhost/litecart");
        WebElement campaignsProduct = driver.findElement(By.cssSelector("#box-campaigns .product"));
        WebElement regularPrice=campaignsProduct.findElement(By.className("regular-price"));
        String regularPriceColor = regularPrice.getCssValue("color");
        Assert.assertTrue("s".equals(regularPrice.getTagName()));
        assertThatColorIs(regularPriceColor,"grey");
        campaignsProduct.findElement(By.cssSelector("a")).click();
        WebElement regularPriceOnProductPage=driver.findElement(By.className("regular-price"));
        String regularPriceColorOnProductPage=regularPriceOnProductPage.getCssValue("color");
        Assert.assertTrue("s".equals(regularPriceOnProductPage.getTagName()));
        assertThatColorIs(regularPriceColorOnProductPage,"grey");
    }

    @Test
    public void verifyThatCampaignsPriceIsRedAndBold() {
        driver.get("http://localhost/litecart");
        WebElement campaignsProduct = driver.findElement(By.cssSelector("#box-campaigns .product"));
        WebElement campaignPrice=campaignsProduct.findElement(By.className("campaign-price"));
        String campaignPriceColor = campaignPrice.getCssValue("color");
        Assert.assertTrue("strong".equals(campaignPrice.getTagName()));
        assertThatColorIs(campaignPriceColor,"red");
        campaignsProduct.findElement(By.cssSelector("a")).click();
        WebElement campaignPriceOnProductPage=driver.findElement(By.className("campaign-price"));
        String campaignPriceColorOnProductPage=campaignPriceOnProductPage.getCssValue("color");
        Assert.assertTrue("strong".equals(campaignPriceOnProductPage.getTagName()));
        assertThatColorIs(campaignPriceColorOnProductPage,"red");
    }

    @Test
    public void verifyCampaignPriceIsLagerThenRegular() {
        driver.get("http://localhost/litecart");
        WebElement campaignsProduct = driver.findElement(By.cssSelector("#box-campaigns .product"));
        WebElement regularPrice = campaignsProduct.findElement(By.className("regular-price"));
        WebElement campaignPrice = campaignsProduct.findElement(By.className("campaign-price"));
        Assert.assertTrue("Compare the areas of rectangles",regularPrice.getSize().height*regularPrice.getSize().width<campaignPrice.getSize().height*campaignPrice.getSize().width);
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


     static void assertThatColorIs(String color,String expectedColor){
         color=color.replaceAll("[^0-9]+"," ");
         List<String> stringList=Arrays.asList(color.trim().split(" "));
         List<Integer> rgb=new ArrayList<>();
         for (String str: stringList) {
             rgb.add(Integer.valueOf(str));
         }
        if ("red".equals(expectedColor)){
            Assert.assertTrue(rgb.get(1).equals(0)&&rgb.get(2).equals(0));
        } else if ("grey".equals(expectedColor)){
            Assert.assertTrue((rgb.get(0).equals(rgb.get(1)))&&(rgb.get(1).equals(rgb.get(2))));
        }
        else {
            throw new AssertionError();
        }
     }
}
