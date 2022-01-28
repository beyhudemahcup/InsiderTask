package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C02_WebTable {

    /*
    create an login method to log in.
    go to this address : https://www.qa-enviroment.concorthotel.com/admin/HotelRoomAdmin
    username : manager
    password : Manager1!
    create an table method
        find all tr in the tbody
        print all table's headers
    create an printRows method
        find all row in the table
        table bodysinde bulunan satirlari konsolda yazdirin
        row elementlerini konsolda yazdirin
        dorduncu sutunu yazdirin
     */

    @Test(groups = "birinci grup")
    public void test() throws InterruptedException {
        QAConcortPage qaConcortPage = new QAConcortPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));

        qaConcortPage.loginPath();

        qaConcortPage.hotelsMenu.click();
        qaConcortPage.hotelRoomsLink.click();

        for (WebElement each: qaConcortPage.basliklarListesi
             ) {

            System.out.println(each.getText());

        }
        Thread.sleep(2000);
        //for each looptan sonra uyutmayinca tabloyu bulup yazdiramiyor..
        //uyutmayi unutma


        System.out.println("tablodaki sutun sayisi : " + qaConcortPage.basliklarListesi.size());

        //butun table i yazdirmak icin //tbody kullanilabilir.
        //ama butun bir string olarak yazdirir

        System.out.println(qaConcortPage.tbodyButunSekilde.getText());
        Assert.assertTrue(qaConcortPage.tbodyButunSekilde.getText().contains("Star Hotel"),
                "table does not contains your hotel");



        //printRow kismina geldik
        System.out.println("tablodaki satir sayisi : "+qaConcortPage.satirlarListesi.size());

        for (int i=0; i<qaConcortPage.satirlarListesi.size(); i++){
            System.out.println(i + ". satir : " + qaConcortPage.satirlarListesi.get(i).getText());
        }
        
        Thread.sleep(1000);

        for (WebElement each: qaConcortPage.tableDorduncuSutun
             ) {
            System.out.println(each.getText());
        }

        //burada da dorduncu sutunu yazdirdik


    }
}
