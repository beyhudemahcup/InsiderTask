package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class N11LoginPage {


    public N11LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "btnSignIn")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='E-posta adresiniz veya şifreniz hatalı']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@class='myBasket ']")
    public WebElement cartIkon;

    public static void goToUrl(){
        Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
    }

}
