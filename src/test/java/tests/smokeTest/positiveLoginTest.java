package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class positiveLoginTest {

    /*
    go to the https://qa-environment.concorthotel.com/
    click to the login button
    test date username : manager
    test data password : Manager1!
    check that to log in without any problem

    */

    @Test
    public void positiveLoginTest(){

        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.loginButton.click();
        qaConcortPage.username.sendKeys(ConfigurationReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigurationReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginSubmitButton.click();

        Assert.assertTrue(qaConcortPage.checkForLogin.isDisplayed(),"some problems occured");
    }
}
