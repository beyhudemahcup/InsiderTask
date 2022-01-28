package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_facebookLoginPOM extends TestBase {
    /*
    go to the facebook login
    enter id = bilal@hotmail.com
    password = 12345
    check that this infos are not enough to log in
     */

    @Test
    public void test(){
        driver.get("https://www.facebook.com");
        FacebookPage facebookPage = new FacebookPage(driver);
        facebookPage.emailBox.sendKeys("bilal@hotmail.com");
        facebookPage.passwordBox.sendKeys("12345");
        facebookPage.loginButton.click();

        Assert.assertTrue(facebookPage.alertBox.isDisplayed(),"your alert message is not visible");
    }


}
