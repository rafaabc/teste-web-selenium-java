package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver browser) {
        super(browser);
    }

    public LoginFormPage typeUsername(String username) {
        browser.findElement(By.id("username")).sendKeys(username);

        return this;
    }

    public LoginFormPage typePassword(String password) {
        browser.findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public SecureAreaPage clickLogin() {
        browser.findElement(By.className("radius")).click();

        return new SecureAreaPage(browser);
    }

    public SecureAreaPage doLogin(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLogin();

        return new SecureAreaPage(browser);
    }

}
