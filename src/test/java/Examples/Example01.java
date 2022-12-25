package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example01 {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));



    }



    @Test
    public void test01() {
        //1-Test01 isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        driver.get("http://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5-”Salesforce Apex Questions Bank” icin arama yapiniz
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Salesforce Apex Questions Bank", Keys.ENTER);
        //6- Kac sonuc bulundugunu yaziniz
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        System.out.println(sonuc.getText());

    }


    @After
    public void teardown () {
        driver.close();
    }

}
