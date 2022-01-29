package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.N11LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NegativeLoginTest  {


    //Pozitif olan testten sonra negatif test senaryosu olarak uc tane olasiligimiz kaldi.
    // 1-valid email-invalid password
    // 2-invalid email-valid password
    // 3-invalid email-invalid password

    N11LoginPage n11LoginPage = new N11LoginPage();

    @Test
    public void TC_002(){
        N11LoginPage.goToUrl();
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11ValidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11InvalidPassword"));
        ReusableMethods.waitFor(2);
        n11LoginPage.loginButton.click();
        ReusableMethods.waitForVisibility(n11LoginPage.errorMessage,5);
        Assert.assertTrue(n11LoginPage.errorMessage.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void TC_003() {
        N11LoginPage.goToUrl();
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11InvalidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11ValidPassword"));
        ReusableMethods.waitFor(2);
        n11LoginPage.loginButton.click();
        ReusableMethods.waitForVisibility(n11LoginPage.errorMessage,5);
        Assert.assertTrue(n11LoginPage.errorMessage.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void TC_004() {
        N11LoginPage.goToUrl();
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11InvalidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11InvalidPassword"));
        ReusableMethods.waitFor(2);
        n11LoginPage.loginButton.click();
        ReusableMethods.waitForVisibility(n11LoginPage.errorMessage,5);
        Assert.assertTrue(n11LoginPage.errorMessage.isDisplayed());
        Driver.closeDriver(); }

    }
