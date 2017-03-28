package thetenthlesson.tests;

import org.junit.Before;
import thetenthlesson.app.Application;

/**
 * Created by Etery on 29.03.2017.
 */
public class BaseTest {


    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @Before
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    app.quit();
                    app = null;
                }));
    }

}
