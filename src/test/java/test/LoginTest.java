package test;

import static org.junit.Assert.*;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginTestData.csv")

public class LoginTest {
    private  WebDriver browser;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        browser = Web.createChrome();
    }

    @Test
    public void testValidLogin(
            @Param(name="username")String username,
            @Param(name="password")String password)
    {

        //digite "tomsmith" no campo com id "username"
        browser.findElement(By.id("username")).sendKeys(username);

        //digite "SuperSecretPassword!" no campo com id "password"
        browser.findElement(By.name("password")).sendKeys(password);

        //clique no botão de login com a classe "radius"
        browser.findElement(By.className("radius")).click();

        //pegue a mensagem exibida na página após o login
        String mensagem = browser.findElement(By.id("flash")).getText();

        //verifique se a mensagem exibida está correta
        String mensagemEsperada = "You logged into a secure area!\n" + "×";
        assertEquals(mensagemEsperada, mensagem);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);

    }

    @Test
    public void testInvalidUsername(
            @Param(name="username")String username,
            @Param(name="password")String password)
    {

        //digite "tomsmith" no campo com id "username"
        browser.findElement(By.id("username")).sendKeys(username);

        //digite "SuperSecretPassword!" no campo com id "password"
        browser.findElement(By.name("password")).sendKeys(password);

        //clique no botão de login com a classe "radius"
        browser.findElement(By.className("radius")).click();

        //pegue a mensagem exibida na página após a tentativa de login
        String mensagem = browser.findElement(By.id("flash-messages")).getText();

        //verifique se a mensagem exibida está correta
        String mensagemEsperada = "Your username is invalid!\n" + "×";
        assertEquals(mensagemEsperada, mensagem);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);

    }

    @Test
    public void testInvalidPassword(
            @Param(name="username")String username,
            @Param(name="password")String password)
    {

        //digite "tomsmith" no campo com id "username"
        browser.findElement(By.id("username")).sendKeys(username);

        //digite "SuperSecretPassword!" no campo com id "password"
        browser.findElement(By.name("password")).sendKeys(password);

        //clique no botão de login com a classe "radius"
        browser.findElement(By.className("radius")).click();

        //pegue a mensagem exibida na página após a tentativa de login
        String mensagem = browser.findElement(By.id("flash-messages")).getText();

        //verifique se a mensagem exibida está correta
        String mensagemEsperada = "Your password is invalid!\n" + "×";
        assertEquals(mensagemEsperada, mensagem);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);

    }

    @Test
    public void testWithNoData() {

        //clique no botão de login com a classe "radius"
        browser.findElement(By.className("radius")).click();

        //pegue a mensagem exibida na página após a tentativa de login
        String mensagem = browser.findElement(By.id("flash-messages")).getText();

        //verifique se a mensagem exibida está correta
        String mensagemEsperada = "Your username is invalid!\n" + "×";
        assertEquals(mensagemEsperada, mensagem);

        String screenshotArquivo = "/home/rafael/Documentos/Projects/teste-web-selenium-java/test-report/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.takeScreenshot(browser, screenshotArquivo);

    }

    @After
    public void tearDown(){
        //fechar o browser browser
        browser.quit();
    }
}