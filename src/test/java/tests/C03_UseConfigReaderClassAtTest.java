package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_UseConfigReaderClassAtTest {
    // Go to Amazon
    // Go to google
    // Use configReader class

    @Test
    public void test() throws InterruptedException {
        //Driver.getDriver().get("https://www.amazon.com./");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Thread.sleep(2000);
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
