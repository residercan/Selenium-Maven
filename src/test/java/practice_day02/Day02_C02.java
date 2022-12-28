package practice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_C02 {

    /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */


    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }

    @Test
    public void test01() throws Exception {
//        https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
//        Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Google"));
//        Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
//        Bulunan sonuc sayisini yazdirin
        String [] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonucSayisi = sonuc[1];
        System.out.println("Sonuc Sayısı: " + sonucSayisi);

//        sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonucSayisi=sonucSayisi.replaceAll("\\D", "");//ReplaceAll methodu ile \\D kullanarak bütün noktalama işaretlerini hiçlikle değiştir.
        int expectedSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonucSayisi)>expectedSayi);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
