package pages.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoLoginPageType1 {
    //bir page sayfasi olsuturuldugunda mutlaka yapmamiz gerekn sey
    //*bir parametresiz constructor olusturup driver a ilk degeri atamaktir
    //*bu sayfadaki butun elemanlarin driverla baglantisi gerekiyor
    //*bunun icin asagidaki constructor eklendi ve PageFactory ile
    //driver uzerinden bu (this) sayfadaki butun elemanlar iliskilendirildi
    //boylece sayfadan obje turetildigi zaman degil, kullanildigi anda elemanlarin bulunmasi aktif olur.
    //*bu yontemle butun sayfalarda ayni isimde elemanlar var ise buradaki tanımlama hepsi icin gecerli hale gelir..
    //bu yapiya POM denir

    public SauceDemoLoginPageType1() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // Elementleri başlatmak, Selenium WebDriver ile çalışırken bir sayfa nesnesindeki web öğelerini WebDriver'ın
    // bulabileceği şekilde yapılandırmaktır. Bu genellikle @FindBy veya @FindBys gibi anotasyonlarla belirtilen
    // öğeleri, gerçek web sayfasındaki HTML öğeleriyle eşleştirir.

    // driver.findElement() yerine @FindBy notasyonu kullanılır.
    // WebElement'ler POM ile;Test classlarında değil, Page Class'larda locate edilir.
    // Erişim sağlanması adına Access Modifier public olmalıdır, kullanırken de @FindBy notasyonu ile locate edilir.
    // Test classlarında kullanırken de Page Class'tan üretilen obje aracılığıyla kullanılabilir.

    //WebElement txtUsername = Driver.getDriver().findElement(By.id("user-name"));

    //Page Class yapisi Type1 : Olusturulan Webelementleri bu class icinde kullanma sekli
    //Bu yapida Webelementleri public yapmamiza gerek yoktur.
    @FindBy(id = "user-name")
    WebElement usernameBox;

    @FindBy(id = "password")
    WebElement passwordBox;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public void loginSauceDemo(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}
