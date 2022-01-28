package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_concortHotelLoginNegative extends TestBase {


    @Test
    public void negativeLoginTest(){

        driver.get("https://www.concorthotel.com");
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginButton.click();
        concortHotelPage.username.sendKeys("manager1");
        concortHotelPage.password.sendKeys("manager1!");
        concortHotelPage.loginSubmitButton.click();

        Assert.assertTrue(concortHotelPage.falseLogin.isDisplayed(),"you could log in. Some problem occured");




    }




}
