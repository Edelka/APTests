package page_factory;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;


@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestRun {


    protected static final String BASE_URL = "http://automationpractice.com/";
    protected  static WebDriver vebDriver;

    @BeforeClass
    public static void setUp(){
        vebDriver = new ChromeDriver();
        vebDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        vebDriver.manage().window().maximize();
        vebDriver.get(BASE_URL);

    }


    @AfterClass
    public static void tearDown() {
        vebDriver.quit();
        vebDriver = null;
    }


    @Test
    public void test01_logIn() {

        //Initialize Login Page
        LoginPage loginPage = PageFactory.initElements(vebDriver, LoginPage.class);
        vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        //Enter user name
        loginPage.enterUserName("epakholchak@gmail.com");
        //Enter Password
        loginPage.enterPassword("12345");
        //Click Login Button
        loginPage.clickSignInBtn();
        //Check site title
        Assert.assertThat("Check site title.", vebDriver.getTitle(), containsString("My account - My Store"));
    }

    @Test
    public void test02_logOut() {
        //Initialize AccountPage
        AccountPage accountPage = PageFactory.initElements(vebDriver, AccountPage.class);
        accountPage.signOut();
        //Check site title
        Assert.assertThat("Check site title.", vebDriver.getTitle(), containsString("Login - My Store"));
    }



}
