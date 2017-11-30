
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


@RunWith(JUnit4.class)
public class FirstTest {


    protected static final String BASE_URL = "https://github.com/";
    protected  static WebDriver vebDriver;

    @BeforeClass
    public static void setUp(){
        vebDriver = new ChromeDriver();
        vebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        vebDriver.manage().window().maximize();
        vebDriver.get(BASE_URL);

          }


  @AfterClass
     public static void tearDown() {
        vebDriver.quit();
        vebDriver = null;
        }



  @Test
     public void gitHubOpen() {

      Assert.assertTrue("Check site title.", vebDriver.getTitle().contains("GitHub"));
         }


    @Ignore
  @Test
        public void searchRep() {
            WebElement inputField = vebDriver.findElement(By.name("q"));
            inputField.click();
            inputField.sendKeys("maven");
            inputField.submit();
            WebElement  firstResult = vebDriver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[1]/div/div[1]/ul/div[1]/div[1]/h3/a/em)"));


        }
 }
