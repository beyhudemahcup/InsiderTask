package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigurationReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigurationReader.getProperty("CHUrl"));





        Driver.closeDriver();
    }
}
