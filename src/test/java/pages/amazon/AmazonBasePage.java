package pages.amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonBasePage {
    // navbar her sayfada ortak oldugundan tekrar tekrar her sayfada ayni webelementleri locate almamak icin
    // burda bu islemleri yapip diger classlara extends edecegiz

    public AmazonBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    WebElement textSearch;

    @FindBy(id="nav-link-accountList-nav-line-1")
    WebElement loginHover;

    @FindBy(id="nav-link-accountList-nav-line-1")
    WebElement login;

    @FindBy(id="ap_email")
    WebElement eMail;

    @FindBy(id="ap_password")
    WebElement passWord;

    @FindBy(id ="nav-cart")
    WebElement btnCart;

    public void login(){
        Actions actions = new Actions(Driver.getDriver());
        actions
                .moveToElement(loginHover)
                .click(login)
                .perform();

        eMail.sendKeys("sivaslirasit@gmail.com", Keys.ENTER);
        passWord.sendKeys("Rs34551040", Keys.ENTER);
    }

    public void searchFor(String keyword){
        textSearch.sendKeys(keyword + Keys.ENTER);
    }

    public void navigateToCart(){
        btnCart.click();
    }
}
