package homework09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class iFrame extends BaseTest {

    @Test
    public void checkIFrame() {
        HomePage homePage = new HomePage(webDriver);
        homePage.scrollToiFrame();
        webDriver.switchTo().frame(homePage.iFrame);
        Assert.assertEquals("PrestaShop", webDriver.findElement(By.xpath("//a[@title='PrestaShop']")).getText());


    }

}
