package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.N11LoginPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class PositiveLoginTest {

    // Decision table testing yaparak tum olasiliklar icin login page'in bize verecegi responselari test edebiliriz

    //Bunun icin 1 pozitif ve 3 negatif test kullanacagim
    //bu classta email ve password icin valid degerler giriyorum
    //TC_001 Kullanici valid email ve valid password degerlerini girer, login oldugunu test eder
    //TC_002 Kullanici valid email ve invalid password degerlerini girer, E-posta adresiniz veya şifreniz hatalı yazisini gorur
    //TC_003 Kullanici invalid email ve valid password degerlerini girer, E-posta adresiniz veya şifreniz hatalı yazisini gorur
    //TC_004 Kullanici invalid email ve invalid password degerlerini girer, E-posta adresiniz veya şifreniz hatalı yazisini gorur

    @Test
    public void TC_001(){
        N11LoginPage.goToUrl();
        N11LoginPage n11LoginPage = new N11LoginPage();
        n11LoginPage.signInButton.click();
        ReusableMethods.waitForPageToLoad(5);
        n11LoginPage.emailBox.sendKeys(ConfigReader.getProperty("n11ValidEmail"));
        n11LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("n11ValidPassword"));
        ReusableMethods.waitFor(2);
        n11LoginPage.loginButton.click();

        ReusableMethods.waitForVisibility(n11LoginPage.cartIkon,8);
        Assert.assertTrue(n11LoginPage.cartIkon.isDisplayed());
    }
}

