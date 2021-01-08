package test;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginFormPage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;
import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginPageObjectTest.csv")

public class LoginPageObjectTest {
    private WebDriver browser;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        browser = Web.createChrome();
    }

    @Test
    public void testValidLogin(
            @Param(name="username")String username,
            @Param(name="password")String password)
    {
        String textMessage = new LoginFormPage(browser)
                .doLogin(username, password)
                .getSuccessTextMessage();

        assertEquals("You logged into a secure area!\n" + "×", textMessage);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);
    }

    @Test
    public void testInvalidUsername(
            @Param(name="username")String username,
            @Param(name="password")String password)
    {
        String textMessage = new LoginFormPage(browser)
                .doLogin(username, password)
                .getInvalidInfoTextMessage();

        assertEquals("Your username is invalid!\n" + "×", textMessage);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);
    }

    @Test
    public void testInvalidPassword(
            @Param(name="username")String username,
            @Param(name="password")String password)
    {
        String textMessage = new LoginFormPage(browser)
                .doLogin(username, password)
                .getInvalidInfoTextMessage();

        assertEquals("Your password is invalid!\n" + "×", textMessage);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);
    }

    @Test
    public void testWithNoData() {
        String textMessage = new LoginFormPage(browser)
                .clickLogin()
                .getInvalidInfoTextMessage();

        assertEquals("Your username is invalid!\n" + "×", textMessage);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

}
