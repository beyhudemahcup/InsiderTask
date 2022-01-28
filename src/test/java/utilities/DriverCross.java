package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public class DriverCross {
    private DriverCross() {
    }

    //get Driver classina "String browser" i parametre olarak ekliyoruz
    //switchdeki degeri de "browser" ile degistiriyoruz
        private static WebDriver driver;
        public static WebDriver getDriver(String browser){
            if (driver==null){

            //null olarak bir browser degeri gelirse kodun ne yapacagini belirtiyoruz
            browser = browser == null ? ConfigurationReader.getProperty("browser") : browser;
            switch (browser) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }
        return driver;
        }
        public static void closeDriver(){

            if (driver!=null) {
                driver.close();
            }
            driver=null;
        }
    }
