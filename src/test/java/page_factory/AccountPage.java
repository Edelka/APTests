package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class AccountPage {


    //Define SignOut field
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement signOut;

    //Define SignOut method
   public void signOut(){
        signOut.click();
    }


}
