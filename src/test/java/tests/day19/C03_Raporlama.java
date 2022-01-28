package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.security.Key;

public class C03_Raporlama extends TestBaseRapor {

    @Test
    public void test(){

        extentTest = extentReports.createTest("nutella testi","sonuc sayisi 1000den kucuk olmali");

        /*
        go to the amazon,
        search to the nutella and test that results are less than
        one thousand
         */
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
        extentTest.pass("amazon sayfasina gidildi");
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(ConfigurationReader.getProperty("amazonSearchWord") +Keys.ENTER);
        extentTest.pass("nutella icin arama yapildi");
        WebElement results = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        //1-48 of 130 results for
        //results olarak bize donen textin icindeki en buyuk sayiyi alip 1000 ile karsilastiracagiz. Bunun icin sonucu bir
        //stringe atayip o stringi bosluklarindan bolup bir arraye atayacagiz. orada indexi 2 olan array bize
        //en fazla olan sayiyi verecek


        String sonucText = results.getText();
        String sonucArray[] = sonucText.split(" ");
        int sonucSayisi = Integer.parseInt(sonucArray[2]);

        extentTest.pass("sonuc sayisi int haline getirildi");

        Assert.assertTrue(sonucSayisi<1000,"sonuc sayisi 1000den kucuk degil");

        extentTest.pass("sonuc sayisinin 1000den az oldugu test edildi");

    }
    @Test
    public void test2(){
        extentTest = extentReports.createTest("samsung testi","sonuc sayisi 1000den kucuk olmali");

        /*
        go to the amazon,
        search to the samsung and test that results are less than
        one thousand
         */

        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
        extentTest.pass("amazon sayfasina gidildi");
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("samsung" +Keys.ENTER);
        extentTest.pass("samsung icin arama yapildi");
        WebElement results = Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        //1-48 of 130 results for
        //results olarak bize donen textin icindeki en buyuk sayiyi alip 1000 ile karsilastiracagiz. Bunun icin sonucu bir
        //stringe atayip o stringi bosluklarindan bolup bir arraye atayacagiz. orada indexi 2 olan array bize
        //en fazla olan sayiyi verecek


        String sonucText = results.getText();
        String sonucArray[] = sonucText.split(" ");
        String sonucAdedi = sonucArray[3];
        sonucAdedi = sonucAdedi.replace(",","");

        int sonucSayisi = Integer.parseInt(sonucArray[3]);

        extentTest.pass("sonuc sayisi int haline getirildi");

        Assert.assertTrue(sonucSayisi<1000,"sonuc sayisi 1000den kucuk degil");

        extentTest.pass("sonuc sayisinin 1000den az oldugu test edildi");



    }
        @Test
        public void test3(){
             /*
        go to the amazon,
        search to the java from electronic category and test that first element is contains "java"
         */

            extentTest=extentReports.createTest("java testi","ilk urunde java olmali");
            Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
            extentTest.info("amazona gidildi");
            Select select=new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
            select.selectByVisibleText("Electronics");
            extentTest.info("dropdown dan electronics secildi");
            WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("Java"+Keys.ENTER);
            extentTest.info("java kelimesi aratildi");
            // cikan sonuclardan ilkinin isminde java oldugunu test edelim
            WebElement ikinciUrun=Driver.getDriver().findElement(By.xpath("(//div[@class='s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom'])[1]"));
            String ikinciElementYazisi=ikinciUrun.getText();
            Assert.assertTrue(ikinciElementYazisi.contains("Java"));
            extentTest.pass("ilk urun isminde java oldugu test edildi");
        }
}
