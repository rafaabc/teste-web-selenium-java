package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Generator;
import suporte.Screenshot;

public class BasePage {
    protected WebDriver browser;

    public BasePage(WebDriver browser) {
        this.browser = browser;
    }

    public String getSuccessTextMessage() {
        return browser.findElement(By.id("flash")).getText();
    }

    public String getInvalidInfoTextMessage() {
        return browser.findElement(By.id("flash-messages")).getText();
    }

}

