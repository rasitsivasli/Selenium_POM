package pages.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class SauceDemoHomePageType2 {

    //Bu 2.yöntemde methodlar test classının içerisinde olacak ve bu yüzden bu classdaki webelementlerle beraber
    // "public" keyword kullanmamız gerekmektedir.

    public SauceDemoHomePageType2() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "select")
    public WebElement dropDown;

    @FindBy(className = "active_option")
    public WebElement dropDownText;

    @FindBy(className = "inventory_item_price")
    public List <WebElement> priceList;

}

