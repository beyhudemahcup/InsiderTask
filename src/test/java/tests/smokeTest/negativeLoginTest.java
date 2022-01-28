package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class negativeLoginTest {

    /*
    check that wrong id, username and password information using
    for username: manager1, password: manager1
     */
    @Test(priority = -1)
    public void negativeLoginTest1(){

        QAConcortPage qaConcortPage = new QAConcortPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));

        qaConcortPage.loginButton.click();
        qaConcortPage.username.sendKeys(ConfigurationReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigurationReader.getProperty("CHQAInvalidPassword"));
        //wrong password
        qaConcortPage.loginSubmitButton.click();

        Assert.assertTrue(qaConcortPage.falseLogin.isDisplayed(),"first test has a problem");

    }
    @Test(dependsOnMethods = "negativeLoginTest1")
    public void negativeLoginTest2(){

        QAConcortPage qaConcortPage = new QAConcortPage();


        qaConcortPage.loginButton.click();
        qaConcortPage.username.clear();
        qaConcortPage.username.sendKeys(ConfigurationReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.password.clear();
        qaConcortPage.password.sendKeys(ConfigurationReader.getProperty("CHQAValidPassword"));
        //wrong id
        qaConcortPage.loginSubmitButton.click();

        Assert.assertTrue(qaConcortPage.falseLogin.isDisplayed(),"second test has a problem");

    }
    @Test(dependsOnMethods = "negativeLoginTest1")
    public void negativeLoginTest3(){

        QAConcortPage qaConcortPage = new QAConcortPage();

        qaConcortPage.loginButton.click();

        qaConcortPage.username.clear();
        qaConcortPage.username.sendKeys(ConfigurationReader.getProperty("CHQAInvalidUsername"));

        qaConcortPage.password.clear();
        qaConcortPage.password.sendKeys(ConfigurationReader.getProperty("CHQAInvalidPassword"));
        //wrong password and id
        qaConcortPage.loginSubmitButton.click();

        Assert.assertTrue(qaConcortPage.falseLogin.isDisplayed(),"third test has a problem");

        Driver.closeDriver();
    }
}
