package page_factory;


import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class LoginPage {


    protected static final String BASE_URL = "http://automationpractice.com/";
    protected  static WebDriver vebDriver;


    @FindBy(id = "email")
    private WebElement login;

    @FindBy(id = "passwd")
    private WebElement pwd;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    //Initialization
    LoginPage(WebDriver webDriver){
        this.vebDriver = vebDriver;
        PageFactory.initElements(webDriver, this);
    }


    //Define Username Enter Method
    public void enterUserName(String username) {
        login.sendKeys(username);
    }

    //Define Password Enter Method
    public void enterPassword(String password) {
        pwd.sendKeys(password);
    }

    //Define Login Button Click Method
    public void clickSignInBtn() {
        loginButton.click();
    }

    public AccountPage logIn(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickSignInBtn();

        return new AccountPage(vebDriver);
    }

}



