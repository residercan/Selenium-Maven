package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day01_C01 {



    /*
-"amazon.com" adresine gidelim
-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
-Ardindan "trendyol.com" adresine gidelim
-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
-Bi onceki web sayfamiza geri donelim
-sayfayi yenileyelim
-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
    */


    WebDriver driver;
    @Before
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }

    @Test
    public void test01 (){

//        -"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com/");
//        -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualAmazonTitle = driver.getTitle();
        String actualAmazonUrl = driver.getCurrentUrl();
//        -title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualAmazonTitle.contains("spend") && actualAmazonUrl.contains("spend"));
//        -Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com/");
//        -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String actualTrendyolTitle = driver.getTitle();
        Assert.assertTrue(actualTrendyolTitle.contains("Sitesi"));
//        -Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
//        -sayfayi yenileyelim
        driver.navigate().refresh();
//        -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();

    }

    @After
    public void teardown() {
        driver.quit();//Birden fazla sayfa çalıştırılınca quit ile kapatmak daha garanti oluyor.
    }



}
