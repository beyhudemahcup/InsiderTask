package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_windowHandleWithRapport extends TestBaseRapor {
    @Test
    public void testReusableIle(){

        extentTest = extentReports.createTest("window Handle Test","yeni sayfada new window yazisini test eder");

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenilen adrese gidildi");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("click here butonuna tiklandi");
        ReusableMethods.switchToWindow("New Window");
        extentTest.info("new windowa gecildi");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("tag name i kontrol edildi");
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        extentTest.pass("tag name in goruldugu test edildi");
        Driver.closeDriver();
        extentTest.pass("sayfa kapatildi");
    }
}
