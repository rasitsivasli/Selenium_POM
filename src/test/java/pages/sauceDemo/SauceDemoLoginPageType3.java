package pages.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class SauceDemoLoginPageType3 {

    public By usernameBoxLocater = By.id("user-name");

    public By passwordBoxLocater = By.id("password");

    public By loginButtonLocater = By.id("login-button");

    public void loginSauceDemo(String username, String password) {
        Driver.getDriver().findElement(usernameBoxLocater).sendKeys(username);

        Driver.getDriver().findElement(passwordBoxLocater).sendKeys(password);

        Driver.getDriver().findElement(loginButtonLocater).click();


    }
}
