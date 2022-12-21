package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_MavenUcuncuTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


//        1-C01_TekrarTesti isimli bir class olusturun

//        2- https://www.google.com/ adresine gidin
            driver.get("https://www.google.com/");

//        3- cookies uyarisini kabul ederek kapatin


//        4-Sayfa basliginin “Google” ifadesi icerdigini test edin
//        5-Arama cubuguna “Nutella” yazip aratin
            driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
//        6-Bulunan sonuc sayisini yazdirin
            WebElement sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
            System.out.println(sonucSayisi.getText());
//        7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

//        8-Sayfayi kapatin
            driver.close();
    }
}
