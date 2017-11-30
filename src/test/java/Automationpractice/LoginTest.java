package Automationpractice;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginTest {


    protected static final String BASE_URL = "http://automationpractice.com/";
    protected  static WebDriver vebDriver;

    @BeforeClass
    public static void setUp(){
        vebDriver = new ChromeDriver();
        vebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        vebDriver.manage().window().maximize();
        vebDriver.get(BASE_URL);

    }


    /*@AfterClass
    public static void tearDown() {
        vebDriver.quit();
        vebDriver = null;
    }*/



    @Test
    public void test01_storeLogin() {
        String username = "epakholchak@gmail.com";
        String pwd = "12345";

        //WebElement clickField = vebDriver.findElement(By.cssSelector("a.login"));
        vebDriver.findElement(By.cssSelector("a.login")).click();
        //clickField.click();

        WebElement inputLogin = vebDriver.findElement(By.id("email"));
        inputLogin.sendKeys(username);

        WebElement inputPwd = vebDriver.findElement(By.id("passwd"));
        inputPwd.sendKeys(pwd);

        WebElement clickSignin = vebDriver.findElement(By.id("SubmitLogin"));
        clickSignin.click();

    }


    @Test

    public void test02_openOrderHistory() {
        WebElement clickSettings = vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        clickSettings.click();
        WebElement clickField = vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span"));
        clickField.click();
        Assert.assertTrue("Check site title.", vebDriver.getTitle().contains("Order history"));


    }

    @Test
    public void test03_openCreditSlips() {
        WebElement clickSettings = vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        clickSettings.click();
        WebElement clickField = vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span"));
        clickField.click();
        Assert.assertTrue("Check site title.", vebDriver.getTitle().contains("slip"));

    }

    @Test
    public void test04_openMyAddress() {
        WebElement clickSettings = vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        clickSettings.click();
        WebElement clickField = vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span"));
        clickField.click();
        Assert.assertTrue("Check site title.", vebDriver.getTitle().contains("Addresses"));

    }

    @Test
    public void test05_openMyPersonalInfo() {
        WebElement clickSettings = vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        clickSettings.click();
        WebElement clickField = vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
        clickField.click();
        Assert.assertTrue("Check site title.", vebDriver.getTitle().contains("Identity"));

    }

    @Test
    public void test06_openMyWishlist() {
        WebElement clickSettings = vebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));
        clickSettings.click();
        WebElement clickField = vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span"));
        clickField.click();
        Assert.assertTrue("Check site title.", vebDriver.getTitle().contains("Store"));

    }
}
