package tests;

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

    @Test(priority = 0)
    public void TC_002(){
        N11LoginPage.goToUrl();
        ReusableMethods.waitForVisibility(n11LoginPage.signInButton,15);
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11ValidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11InvalidPassword"));
        n11LoginPage.verifyErrorIsDisplayed();
        Driver.closeDriver();
    }

    @Test(priority = 1)
    public void TC_003() {
        N11LoginPage.goToUrl();
        ReusableMethods.waitForVisibility(n11LoginPage.signInButton,15);
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11InvalidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11ValidPassword"));
        n11LoginPage.verifyErrorIsDisplayed();
        Driver.closeDriver();
    }

    @Test(priority = 2)
    public void TC_004() {
        N11LoginPage.goToUrl();
        ReusableMethods.waitForVisibility(n11LoginPage.signInButton,15);
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11InvalidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11InvalidPassword"));
        n11LoginPage.verifyErrorIsDisplayed();
        Driver.closeDriver();
    }
}
