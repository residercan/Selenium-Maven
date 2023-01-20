package day17_Javascript_Executors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day17_C01_JSExecutor_Scroll extends TestBase {


//    scrollIntoViewTest metotu olustur
//    Techpro education ana sayfasina git
//    We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
//    Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
//    Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
//    Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al



    @Test
    public void scrollIntoViewTest() throws Exception {


//    scrollIntoViewTest metotu olustur
//    Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
//    We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
//        1.Adım Elementi bul
        WebElement weOffer = driver.findElement(By.xpath("//*[.='we offer']"));
//        2.Adım JS Executors objesi oluştur
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        3.Adım Yapmak istediğim işlemi js.executeScript methodu ile yap
//        scrollIntoView(true); methodu belirli bir elemente scroll yapmak için kullanılır.
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        waitFor(3);
//        sayfa görüntüsü al
        takeScreenShotOfPage();

//    Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enrollFree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
//        TestBase Utils'de oluşturduğumuz methodu çağırarak işlemi gerçekleştiriyoruz
        scrollIntoViewJS(enrollFree);
        waitFor(3);
        takeScreenShotOfPage();
//    Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement whyUs = driver.findElement(By.xpath("//*[.='WHY US?']"));
        scrollIntoViewJS(whyUs);
        waitFor(3);
        takeScreenShotOfPage();
//    Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(enrollFree);
        waitFor(3);
        takeScreenShotOfPage();

//    Sayfanın en altına git
        scrollEndJS();
        waitFor(3);

//    Sayfanın en üstüne git
        scrollTopJS();
        waitFor(3);

    }


}
