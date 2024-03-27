package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.amazon.AmazonBasePage;
import pages.amazon.AmazonCartPage;
import pages.amazon.AmazonProductPage;
import pages.amazon.AmazonSearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_AmazonTestCase {
    //https://www.amazon.com/ a gidilir
    //arama kutusuna {search_keyword} yazildiktan sonra arama yapilir
    //gelen ilk urun sepete eklenir
    //sepete gidilir
    //sepette alinan urunun sayisi{quantity} arttirilir
    //sepet tutari urunFiyati*quantity olarak bulunmalidir

    //anaSayfa-aramaSayfasi-urunSayfasi-sepetSayfasi
    @Test
    public void test() throws InterruptedException {
        //https://www.amazon.com/ a gidilir
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.amazonCaptcha(Driver.getDriver());

        //Siteye login olunur.
        // Daha önceki Selenium JUnit sonunda Amazon bitirme ödevindeki elment ve
        // login olmak icin gerekli method AmazonBasePage e login methodu olarak eklendi.
        AmazonBasePage amazonBasePage = new AmazonBasePage();
        amazonBasePage.login();

        //arama kutusuna {search_keyword} yazildiktan sonra arama yapilir

        amazonBasePage.searchFor("samsung");

        //gelen ilk urun sepete eklenir
        AmazonSearchPage amazonSearchPage = new AmazonSearchPage();
        amazonSearchPage.navigateToProduct(0);

        //gelen ilk urun sepete eklenir
        AmazonProductPage amazonProductPage = new AmazonProductPage();
        amazonProductPage.addProductToCart();

        //sepete gidilir
        amazonBasePage.navigateToCart();


        //sepette alinan urunun sayisi{quantity} arttirilir
        AmazonCartPage amazonCartPage = new AmazonCartPage();
        amazonCartPage.selectOuantity("3");

        //sepet tutari urunFiyati*quantity olarak bulunmalidir
        Thread.sleep(2000);// toplam fiyat in güncelenebilmesi icin wait yaptim.
        Assert.assertEquals(amazonCartPage.getSubTotalAmount(), amazonCartPage.getProductPrice()*amazonCartPage.quantity);
        Driver.closeDriver();

    }


}
