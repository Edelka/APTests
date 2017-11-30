package Automationpractice;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SearchTest {


    protected static final String BASE_URL = "http://automationpractice.com/";
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

    public void test01_search() {

        String searchResult = "Printed Summer Dress";

        WebElement inputField = vebDriver.findElement(By.id("search_query_top"));
        inputField.click();
        inputField.sendKeys(searchResult);
        inputField.submit();

        //1st search result
        Assert.assertTrue("Check title",vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div")).getText().contains(searchResult));

        //2nd search result
        Assert.assertTrue("Check title",vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div")).getText().contains(searchResult));

        //3rd search result; it is not equal to "Printed Summer Dress"
        Assert.assertFalse("Check title",vebDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div")).getText().contains(searchResult));

    }


}
