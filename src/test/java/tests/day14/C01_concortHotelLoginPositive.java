package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_concortHotelLoginPositive extends TestBase {
    /*
    siteye dogru bilgiler esliginde girilebildigini test edelim

    go to the "https://www.concorthotel.com/
    click login
    fill the form id: manager
    pasword: Manager1!
    and test that to log in successfuly

     */

    @Test
    public void positiveLoginTest(){
        driver.get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);
        concortHotelPage.loginButton.click();
        concortHotelPage.username.sendKeys("manager");
        concortHotelPage.password.sendKeys("Manager1!");
        concortHotelPage.loginSubmitButton.click();

        Assert.assertTrue(concortHotelPage.checkForLogin.isDisplayed(),"password or id is not correct");
    }



}
