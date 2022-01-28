package tests.day25;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DataProviderTest {

    @DataProvider
    public static Object[] aranacakKelimeListesi() {
        String [] kelimeListesi = {"Nutella","Kalem","Apple"};
        return kelimeListesi;
    }

    @Test(dataProvider = "aranacakKelimeListesi")
    public void test(String aranacakKelime){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(aranacakKelime+Keys.ENTER);
        String sonuclar = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        System.out.println(sonuclar);

        Assert.assertTrue(sonuclar.contains(aranacakKelime));
    }
}
