package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage2 {


    WebDriver driver;

    public AmazonPage2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@aria-describedby='searchDropdownDescription']")
    public WebElement dropBox;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement firstResult;

    @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement results;











}
