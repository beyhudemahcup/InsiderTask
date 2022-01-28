package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

    WebDriver driver;
    public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='navLogon']")
    public WebElement loginButton;

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginSubmitButton;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement checkForLogin;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement falseLogin;

    @FindBy(id = "menuHotels")
    public WebElement hotelsMenu;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[2]")
    public WebElement hotelList;

    @FindBy(className = "hidden-480")
    public WebElement addButton;

    @FindBy(id = "Code")
    public WebElement codeBox;

    @FindBy(id = "btnSubmit")
    public WebElement addSubmitButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement addSuccessfullyButton;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[3]")
    public WebElement hotelRoomsLink;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement listOfHotelRooms;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButtonAfterAddHotel;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyButunSekilde;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public List<WebElement> tableDorduncuSutun;

    public void loginPath(){
        QAConcortPage qaConcortPage = new QAConcortPage();
        qaConcortPage.loginButton.click();
        qaConcortPage.username.sendKeys(ConfigurationReader.getProperty("CHQAValidUsername"));
        qaConcortPage.password.sendKeys(ConfigurationReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginSubmitButton.click();
    }


    public String printData(int satir, int sutun) {

        //soruda istenildigi gibi 3. sutun 5. satirdakai elementi yazdiralim

        String xpath = "//tbody//tr["+ satir +"]//td["+ sutun +"]";

        String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir no " + satir + ", sutun no : " + sutun
                + "'deki data : " + istenenData);

        return istenenData;
    }
}











