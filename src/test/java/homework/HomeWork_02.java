package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class HomeWork_02 extends TestBase {



    @Test
    public void test01() throws InterruptedException {

//    Bir class olusturun: IframeOdev
//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
//    sayfadaki toplam iframe sayısını bulunuz.
        driver.findElement(By.xpath("//iframe"));
//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actualtext.contains("Editor"));
//    Paragrafdaki yaziyi silelim
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        Thread.sleep(3000);

//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("iframein icindeyim");
        Thread.sleep(3000);
//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String actualtext1 = driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).getText();
        Assert.assertEquals("Elemental Selenium", actualtext1);

    }


}
