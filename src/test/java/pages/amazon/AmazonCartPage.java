package pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AmazonCartPage extends AmazonBasePage{
    public AmazonCartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath =  "//select[@data-action='a-dropdown-select']")
    WebElement dropQuantity;


    @FindBy(id = "sc-subtotal-label-activecart")
    public WebElement subTotalLabel;


    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    public WebElement subTotalAmount;


    @FindBy(xpath ="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']" )
    public WebElement productPrice;

    public void selectOuantity(String  quantity) {
        Select select = new Select(dropQuantity);
        select.selectByValue(quantity);

    }

    public double getProductPrice(){
        //$ isareti oldugundan manipule ettik..
        String productAmaunt = productPrice.getText().replaceAll("[^0-9]", "");
        System.out.println("productAmaunt = " + productAmaunt);
        return Double.parseDouble(productAmaunt);
    }

    public double getSubTotalAmount(){
        String totalAmaunt = subTotalAmount.getText().replaceAll("[^0-9]", "");
        System.out.println("TotalAmount = " + totalAmaunt);
        return Double.parseDouble(totalAmaunt);
    }
    @FindBy()
    public int quantity=3;
}
