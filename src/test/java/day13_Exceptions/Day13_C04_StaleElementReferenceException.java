package day13_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day13_C04_StaleElementReferenceException extends TestBase {

    /*
        StateElementReferenceException
    StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
    Sayfayı yenilediğimizde,
    sayfada ileri geri gittiğimizde meydana gelen exception'dır.

        Çözüm
    Elemanı tekrar bulmak.

     */


    @Test
    public void staleElementReferenceExceptionTest() throws Exception {

        driver.get("https://www.techproeducation.com");

//        LMS login linkine tıkla ve o sayfanın URL'inin LMS içerdiğini test et
        WebElement lmsLoginLink = driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]"));
        lmsLoginLink.click();
        waitFor(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URL'in lms kelimesini içerip içermediğini test ediyoruz.
        waitFor(3);
//        Tekrar ana sayfaya gel ve LMS login sayfasına tekrar git.
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(3);
        lmsLoginLink.click();//tekrar lms login sayfasına gidiyoruz.
        /*
        lmsLoginLink linkini sayfayı yeniledikten (back()) sonra kullandığım için StaleElementReferenceException aldım.
         */
    }


    @Test
    public void staleElementReferenceExceptionTest2() throws Exception {

        driver.get("https://www.techproeducation.com");
        WebElement lmsLoginLink = driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]"));
        lmsLoginLink.click();
        waitFor(3);
        driver.navigate().refresh();
        waitFor(3);
        //Sayfa yenilenmeden önce bulduğum elementi sayfa yenilendikten sonra kullanmak istedim.
        lmsLoginLink.click();//StaleElementReferenceException hatası alıyoruz.

//        Çözüm: eski elementi tekrar locate et.
//        driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]")).click;

    }


}
