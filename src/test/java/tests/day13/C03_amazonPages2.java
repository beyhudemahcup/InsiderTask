package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage2;
import utilities.TestBase;

import java.util.Set;

public class C03_amazonPages2 extends TestBase {


    /*
    go to the amazon
    click to books category
    search java
    print result numbers
    test that first product's name contains java
     */


    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        AmazonPage2 amazonPage2 = new AmazonPage2(driver);
        Select select = new Select(amazonPage2.dropBox);
        select.selectByVisibleText("Books");
        amazonPage2.searchBox.sendKeys("java" + Keys.ENTER);
        System.out.println(amazonPage2.results.getText());
        String first = amazonPage2.firstResult.getText();

        System.out.println(first);
        Assert.assertTrue(first.contains("java"),"first product does not contain java word");
        //the name of the book is case sensitive. So, books name contains Java, not java.

    }


}
