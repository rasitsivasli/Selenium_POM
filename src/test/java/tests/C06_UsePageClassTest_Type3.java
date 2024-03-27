package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sauceDemo.SauceDemoHomePageType2;
import pages.sauceDemo.SauceDemoLoginPageType1;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_UsePageClassTest_Type3 {
    //Navigate to https://www.saucedemo.com/
    //Enter the username as standard_user
    //Enter the password as secret_sauce
    //Click on login button.
    //- Choose price low to high
    //- Verify item prices are sorted from low to high with hard Assert.

    @Test
    public void test(){
        SauceDemoLoginPageType1 sdlp3 = new SauceDemoLoginPageType1();

        //Navigate to https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));
        //Enter the username as standard_user
        //Enter the password as secret_sauce
        //Click on login button.
        sdlp3.loginSauceDemo("standard_user", "secret_sauce");

        //- Choose price low to high
        SauceDemoHomePageType2 sdhp2 = new SauceDemoHomePageType2();
        Select select = new Select(sdhp2.dropDown);

        select.selectByValue("lohi");

        //- Verify item prices are sorted from low to high with hard Assert.
        Assert.assertTrue(sdhp2.dropDownText.getText().contains("low to high"));

        // burada istersek listeyi yazdirabiliriz..

        for (int i = 0; i <sdhp2.priceList.size()-1 ; i++) {
            double firstPrice = Double.parseDouble(sdhp2.priceList.get(i).getText().substring(1));
            double secondPrice = Double.parseDouble(sdhp2.priceList.get(i+1).getText().substring(1));
            Assert.assertTrue(firstPrice<=secondPrice);
        }

    }
}
