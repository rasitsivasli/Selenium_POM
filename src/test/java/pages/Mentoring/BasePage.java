package pages.Mentoring;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class BasePage {
    // navbar her sayfada ortak oldugundan tekrar tekrar her sayfada ayni webelementleri locate almamak icin
    // burda bu islemleri yapip diger classlara extends edecegiz

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "box1")
    public WebElement oslo;

    @FindBy(id = "box2")
    WebElement washing;

    @FindBy(id = "box3")
    WebElement madrid;

    @FindBy(id = "box4")
    WebElement seul;

    @FindBy(id = "box5")
    WebElement rome;

    @FindBy(id = "box6")
    WebElement koph;

    @FindBy(id = "box7")
    WebElement stock;

    @FindBy(id = "box101")
    WebElement italy;

    @FindBy(id = "box102")
    WebElement spain;

    @FindBy(id = "box103")
    WebElement norvec;

    @FindBy(id = "box104")
    WebElement soutKorea;

    @FindBy(id = "box105")
    WebElement uStates;

    @FindBy(id = "box106")
    WebElement denmark;

    @FindBy(id = "box107")
    WebElement sweden;
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("dtmlUrl"));
        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(oslo,norvec)
                .dragAndDrop(madrid,spain)
                .dragAndDrop(rome,italy)
                .dragAndDrop(koph,denmark)
                .dragAndDrop(seul,soutKorea)
                .dragAndDrop(washing,uStates)
                .dragAndDrop(stock,sweden)
                .perform();

    }
}
