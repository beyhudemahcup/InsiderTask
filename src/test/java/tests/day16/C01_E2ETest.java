package tests.day16;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QAConcortPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_E2ETest {
    /*
        create method "createHotel"
        go to the website
        log your account in
        Click add hotel button with following this path : Hotel management/Hotel List
        give values whatever you want every boxes
        click to the save button
        test that alert of "Hotel was inserted successfully" is visible
        Click to the OK button
        Click to the Hotel Rooms link
        verify that "LIST OF HOTELROOMS" text is visible

         */
    @Test
    public void roomCreateTest() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage = new QAConcortPage();

        qaConcortPage.loginButton.click();
        qaConcortPage.username.sendKeys(ConfigurationReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigurationReader.getProperty("CHQAValidPassword"));

        qaConcortPage.loginSubmitButton.click();

        qaConcortPage.hotelsMenu.click();
        qaConcortPage.hotelList.click();
        qaConcortPage.addButton.click();

        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());


        actions.
                click(qaConcortPage.codeBox).
                sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).
                perform();

        qaConcortPage.addSubmitButton.click();

        Thread.sleep(1500);

        Assert.assertTrue(qaConcortPage.addSuccessfullyButton.isDisplayed(),"hotel creation was not successful");

        qaConcortPage.okButtonAfterAddHotel.click();

        qaConcortPage.hotelRoomsLink.click();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(qaConcortPage.listOfHotelRooms.isDisplayed(),"a new hotel is not visible");

        softAssert.assertAll();
    }
}
