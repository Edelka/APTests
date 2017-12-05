package page_factory;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;


@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestRun {


    protected static final String BASE_URL = "http://automationpractice.com/";
    protected  static WebDriver vebDriver;
    protected String username = "epakholchak@gmail.com";
    protected String password = "12345";

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

    @Ignore
    @Test
    public void test01_logIn() {

        //click on SignIn item
        vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        LoginPage loginPage = new LoginPage(vebDriver);
        AccountPage accountPage = loginPage.logIn(username, password);

        Assert.assertThat("Check site title.", vebDriver.getTitle(), containsString("My account - My Store"));
    }


    @Test
    public void test02_logIn() {

        //click on SignIn item
        vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        LoginPage loginPage = new LoginPage(vebDriver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInBtn();
        AccountPage accountPage = new AccountPage(vebDriver);
        Assert.assertThat("Check site title.", vebDriver.getTitle(), containsString("My account - My Store"));
    }

    @Test
    public void test03_logOut() {

        LoginPage loginPage = new LoginPage(vebDriver);
        AccountPage accountPage = new AccountPage(vebDriver);
        loginPage = accountPage.signOut();
        Assert.assertThat("Check site title.", vebDriver.getTitle(), containsString("Login - My Store"));
    }



}
