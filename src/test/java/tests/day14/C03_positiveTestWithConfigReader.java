package tests.day14;

import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class C03_positiveTestWithConfigReader extends TestBase {

    /*
    go to the "https://www.concorthotel.com/
    click login
    fill the form id: manager
    pasword: Manager1!
    and test that to log in successfuly

     */

    @Test
    public void positiveTestConfig(){
        driver.get(ConfigurationReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);

        concortHotelPage.loginButton.click();
        concortHotelPage.username.sendKeys(ConfigurationReader.getProperty("CHValidUsername"));
        concortHotelPage.password.sendKeys(ConfigurationReader.getProperty("CHValidPassword"));
        concortHotelPage.loginSubmitButton.click();


    }
}
