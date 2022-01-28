package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C01_pages extends TestBase {

    /*
    go to the amazon
     search nutella
     print all results and check that results contain "nutella"
     */


    @Test
    public void testPOM(){

        driver.get("https://www.amazon.com");
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.searchBox.sendKeys("nutella" + Keys.ENTER);
        System.out.println(amazonPage.results.getText());
        Assert.assertTrue(amazonPage.results.getText().contains("nutella"),"result has not have your input ");
    }









}
