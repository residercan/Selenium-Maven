package day13_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Day13_C02_TimeOutException extends TestBase {


    /*
        TimeOutException
    TimeOutException explicit wait kullanıldığı zaman ve element bulunamadığında alınan bir hatadır.
    Şimdiye kadar karşılaşmamızın nedeni sadece implicit wait kullanmış olmamızdır.
    Explicit wait ve yanlış locatar kullandığımız zaman TimeOutException alırız.
    Explicit wait var, doğru locatar kullandık ama süre yeterli olmadığı durumlarda TimeOutException alırız.
    Explicit wait var, doğru locatar kullandık, süre yeterli ama iframe var TimeOutException alırız.
        Çözüm
    Süreyi artırabiliriz.
    Farkli explicit wait yöntemleri kullanırız. Örn: VisibilityOfElementLocated çözmedi yerine presenceOfElementLocator kullanılabilir.
    Ya da javascript executor da ki waitleri sayfa geçişlerini beklemek için kullanabiliriz.
    Locatorı kontrol ederiz.
    Frameworkümde hazır reusable methodlar var. Bu durumda TimeOutException aldığımda o methodlar yardımıyla problemi çözebiliriz.

    */


    @Test
    public void timeOutExceptionTest() throws Exception {

        driver.get("https://www.techproeducation.com");
//        Expilicit wait için oluşturduğumuz methodlardan birini kullanıyoruz.
//        Parametre 1: beklemek istediğimiz element, Parametre 2: Max süre
//        Bilerek locater kısmını hatalı şekilde alıyoruz.
//        waitForVisibility(By.xpath("//input[@type='searchh '"), 15).sendKeys("QA", Keys.ENTER);

//        Bu kısımda sıfırdan expilicit wait objesi oluşturup yapıyoruz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Yanlıs ID")));
//        Expilicit wait kullandığımız için locator da hatalı olduğu için TimeOutException hatası alıyoruz.


    }


}
