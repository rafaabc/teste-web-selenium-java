package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
        //criando uma instância do navegador
        System.setProperty("webdriver.chrome.driver","/usr/driver/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //acessando a página principal
        navegador.get("http://the-internet.herokuapp.com/login");

        return navegador;
    }

}
