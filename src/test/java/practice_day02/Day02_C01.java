package practice_day02;

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
import java.util.List;

public class Day02_C01 {

    /*
- ebay sayfasina gidiniz
- electronics bolumune tiklayiniz
- genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
- her sayfanin basligini yazdiralim
- sayfayi kapatalim
 */

    WebDriver driver;
   @Before
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
   }

   @Test
    public void test01(){
       driver.get("http://www.ebay.com");//- ebay sayfasina gidiniz
       driver.findElement(By.xpath("(//*[@_sp='p2481888.m1379.l3250'])[1]")).click();//- electronics bolumune tiklayiniz

       for(int i = 0; i <24; i++){
           List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));//- genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
           urunler.get(i).click();
           System.out.println(i+" başlık: " + driver.getTitle());//- her sayfanin basligini yazdiralim
           driver.navigate().back();
       }

   }

   @After
    public void teardown(){
       driver.close();//- sayfayi kapatalim
   }



}
