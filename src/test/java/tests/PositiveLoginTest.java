package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.N11LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PositiveLoginTest {


    @Test
    public void TC_001(){
        N11LoginPage.goToUrl();
        N11LoginPage n11LoginPage = new N11LoginPage();
        ReusableMethods.waitForClickability(n11LoginPage.signInButton,15);
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11ValidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11ValidPassword"));
        ReusableMethods.waitFor(2);
        n11LoginPage.loginButton.click();

        ReusableMethods.waitForVisibility(n11LoginPage.cartIkon,8);
        Assert.assertTrue(n11LoginPage.cartIkon.isDisplayed(),"Basarili bir giris yapilamadi..");
        Driver.closeDriver();
    }
}

