package custom_conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.IndexOutOfBoundsException.*;

public class SearchResultsPage {

    WebDriver webDriver;


    SearchResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //#1 Custom Condition: listNthElementHasText
    public ExpectedCondition<Boolean> listNthElementHasText (By locator, int elemNo, String searchText){

       List<WebElement> list = webDriver.findElements(locator);
       return ExpectedConditions.textToBePresentInElement(list.get(elemNo), searchText);

    }

    //#2 Custom Condition: pageIsLoaded
    public ExpectedCondition<Boolean> pageIsLoaded(String pageTitle, String url){
        return(ExpectedConditions.and(
                ExpectedConditions.titleContains(pageTitle),
                ExpectedConditions.urlContains(url)));
    }

    //#3 Custom Condition: stalenessOfElement
    public ExpectedCondition<Boolean> stalenessOfElement(By locator){
        return ExpectedConditions.invisibilityOfElementLocated(locator);
    }

}
