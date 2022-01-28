package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@value='1']")
    public WebElement loginButton;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "pass")
    public WebElement passwordBox;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertBox;


    public FacebookPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


}
