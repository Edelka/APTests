package homework09;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;



public class BaseTest {

    private static final Logger LOG = LogManager.getLogger(BaseTest.class);
    protected static final String BASE_URL = "http://automationpractice.com";
    protected static WebDriver webDriver;

    @Rule
    public TestRule rule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }
    };

    private void captureScreenshot(String methodName) {
        File screenshot = ((TakesScreenshot)webDriver)
                .getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("report.path") + "/screenshots/" + screenshot.getName();
        try {
            FileUtils.copyFile(screenshot, new File(path));
            LOG.info("The screenshot is: " + screenshot.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @BeforeClass
    public static void setUp() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.SEVERE);
        logs.enable(LogType.DRIVER, Level.WARNING);
        logs.enable(LogType.PERFORMANCE, Level.INFO);
        logs.enable(LogType.SERVER, Level.ALL);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

        webDriver = new ChromeDriver(desiredCapabilities);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
        webDriver = null;
    }

    static {
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }


    }
}
