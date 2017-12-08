package custom_conditions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CustomConditionsRun {

    protected static WebDriver webDriver;
    protected static final String BASE_URL = "http://automationpractice.com/";
    protected By item = By.xpath("//div[@class='block_content']//a[@class='product-name']");
    protected By pageElemnt = By.xpath("//*[@id=\"search\"]/div[2]/ul/li[5]");
    protected String searchInput = "dress";

    @BeforeClass
    public static void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void tearsDown() {
        webDriver.quit();
        webDriver = null;
    }

    //checking our custom condition
    public static void assertThat(ExpectedCondition<Boolean> condition){
        (new WebDriverWait(webDriver,5)).until(condition);
    }

    @Test
    public void test01_elemByNoHasText(){
        MainPage mainPage = new MainPage(webDriver);
        SearchResultsPage searchResultsPage = mainPage.enterQuery(searchInput);
        assertThat(searchResultsPage.listNthElementHasText(item, 3, "Summer"));
    }

    @Test
    public void test02_titleAndUrlContainsText(){
        MainPage mainPage = new MainPage(webDriver);
        SearchResultsPage searchResultsPage = mainPage.enterQuery(searchInput);
        assertThat(searchResultsPage.pageIsLoaded("Search - My Store", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search="));
    }

    @Test
    public void test03_elemIsInvisible(){
        MainPage mainPage = new MainPage(webDriver);
        SearchResultsPage searchResultsPage = mainPage.enterQuery(searchInput);
        assertThat(searchResultsPage.stalenessOfElement(pageElemnt));
    }
}
