package tests.day15;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C02_E2ETest {

      /*
        create method "createHotel"
        go to the website
        log your account in
        Click add hotel button with following this path : Hotel management/Hotel List
        give values whatever you want every boxes
        click to the save button
        test that alert og "Hotel was inserted successfully" is visible
        Click to the OK button
         */

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage = new QAConcortPage();

        qaConcortPage.loginButton.click();
        qaConcortPage.username.sendKeys(ConfigurationReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigurationReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginSubmitButton.click();

        qaConcortPage.hotelsMenu.click();
        qaConcortPage.hotelList.click();
        qaConcortPage.addButton.click();

        qaConcortPage.codeBox.sendKeys("1234"
                + Keys.TAB + "Hotel Beauty"
                + Keys.TAB + "Taksim/Istanbul"
                + Keys.TAB + "05555555555"
                + Keys.TAB + "beautyhotel@gmail.com"
                + Keys.TAB + Keys.ENTER
                + Keys.ARROW_DOWN + Keys.ENTER);

        qaConcortPage.addSubmitButton.click();

        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.addSuccessfullyButton.isDisplayed(),"you can not add another hotel. There is a problem here");

        qaConcortPage.okButtonAfterAddHotel.click();




    }
}
