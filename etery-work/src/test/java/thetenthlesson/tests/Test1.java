package thetenthlesson.tests;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Etery on 28.03.2017.
 */
public class Test1 extends BaseTest {

    @Test
    public void test1() {
        Assert.assertEquals(0, app.getQuantity());
        app.addThreeProductsToCart();
        Assert.assertEquals(3, app.getQuantity());
        app.deleteProductsFromCart();
        Assert.assertEquals(0, app.getQuantity());
    }
}
