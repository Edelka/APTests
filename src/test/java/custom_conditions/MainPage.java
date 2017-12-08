package custom_conditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver webDriver;

    @FindBy(id = "search_query_top")
    WebElement searchQuery;

    @FindBy (name = "submit_search")
    WebElement submit;

    MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //searching method
    public SearchResultsPage enterQuery (String query){
        searchQuery.clear();
        searchQuery.sendKeys(query);
        submit.click();
        return new SearchResultsPage(webDriver);
    }

}
