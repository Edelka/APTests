package lesson06.b_implicitly_waits_hepls_only_once;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstTest {

    static final String BASE_URL = "http://automationpractice.com/index.php";
    static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
        webDriver = null;
    }

    @Test
    public void test_advices(){
        WebElement searchfield = webDriver.findElement(By.id("search_query_top"));
        searchfield.sendKeys("Dress");
        String advice1 = webDriver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText();
        Assert.assertThat("Check dress.", advice1, containsString("Dress"));
        searchfield.clear();
        searchfield.sendKeys("shirt");
        String advice2 = webDriver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText();
        Assert.assertThat("Check shirt.", advice2, containsString("shirt"));
    }
}
