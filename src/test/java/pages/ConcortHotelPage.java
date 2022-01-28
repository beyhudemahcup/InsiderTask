package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    WebDriver driver;

    public ConcortHotelPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
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




}
