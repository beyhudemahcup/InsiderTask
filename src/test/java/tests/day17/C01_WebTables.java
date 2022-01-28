package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ConfigurationGroupMethods;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_WebTables {
    //Bir class oluşturun : C02_WebTables
    //● login() metodun oluşturun ve oturum açın.
    //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
    //			○ Username : manager
    //			○ Password : Manager1!
       // 1. pages sayfasinda bir metod oluşturun : printData(int row, int column);
    //	 Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
    //	hücredeki(cell) veriyi yazdırmalıdır.

    //	2. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //	   Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır

    //	3. yazdirilan datanin olmasi gereken dataya (USA) esit oldugunu test edin
    // assert'u bu class'da yapmak istiyorsak istenen datanin bu class'a donmesini saglamaliyiz
    @Test(groups = "birinci grup")
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.loginPath();
        qaConcortPage.hotelsMenu.click();
        qaConcortPage.hotelRoomsLink.click();


        String actualData = qaConcortPage.printData(3,5);

        Assert.assertEquals(actualData,"USA","output is different");


    }
}
