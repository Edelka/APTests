package page_factory;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class LoginPage {

    protected static final String BASE_URL = "http://automationpractice.com/";
    protected  static WebDriver vebDriver;

    //Define User name Field
    @FindBy(id = "email")
    private WebElement login;

    //Define Password Field
    @FindBy(id = "passwd")
    private WebElement pwd;

    //Define Login Button
    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    //Define Username Enter Method
    public void enterUserName(String username)
    {
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


}



