package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class AccountPage {

    static WebDriver webDriver;

    //Define SignOut field
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement signOut;

    //Initialization
    AccountPage(WebDriver vebDriver){
        this.webDriver = vebDriver;
        PageFactory.initElements(vebDriver, this);
    }

    //Define SignOut method
   public LoginPage signOut(){
        signOut.click();
       return new LoginPage(webDriver);
    }


}
