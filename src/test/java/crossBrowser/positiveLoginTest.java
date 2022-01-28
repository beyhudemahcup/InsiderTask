package crossBrowser;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class positiveLoginTest extends TestBaseCross {
    /*
    go to the https://qa-environment.concorthotel.com/
    click to the login button
    test date username : manager
    test data password : Manager1!
    check that to log in without any problem
    */

    @Test
    public void positiveLoginTest(){
    driver.get(ConfigurationReader.getProperty("CHQAUrl"));

    driver.findElement(By.xpath("//li[@id='navLogon']")).click();
    driver.findElement(By.id("UserName")).sendKeys(ConfigurationReader.getProperty("CHQAValidUsername"));
    driver.findElement(By.id("Password")).sendKeys(ConfigurationReader.getProperty("CHQAValidPassword"));
    driver.findElement(By.id("btnSubmit")).click();
    Assert.assertTrue(driver.findElement(By.xpath( "//span[text()='ListOfUsers']")).isDisplayed(),"some problem has occured");
    }
}
