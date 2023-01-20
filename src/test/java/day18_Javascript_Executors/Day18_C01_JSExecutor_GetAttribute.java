package day18_Javascript_Executors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day18_C01_JSExecutor_GetAttribute extends TestBase {

    /*
                JS Interview Question

        1-Javascript Executor nedir?
        Selenium'dan gelen ve javascript kodlarını çalıştırmaya yarayan bir interfacedir.
        Normal selenium methotları yeterli olmadığı durumlarda kullanılabilir.

        2-Ne zaman ve nasıl kullandın?
        Ornegin, bazi butonlara tiklamada problem olabilir, ya da belirli bir web elementin
        gorunur olacagi sekilde sayfanin kaydirma islemi, ya da input kutularindaki degerleri
        almak icin kullanilabilir.

        3-Sayfayı aşağı veya yukarı kaydırma işlemi selenium'da nasıl yapılır?
        Selenium'daki Actions ya da javascript executor method'lari ile kaydirma islemleri yapilabilir.
        Ornegin, actionslarda page_up,page_down,arrow_up,arrow_down method'lari ile ya da javascript executor'daki scrollIntoView(true)
        ile yapilabilir. Ben olusturulmus reusable method'larini kullanarak bu islemleri kolaylikla yapabiliyorum.

        4-Bir kutucuktaki(inputtaki) elemanın metni nasıl alınabilir?
        Javascript Executor ile alabiliriz. Çünkü js executor ile attribute değerlerini alma imkanımız var.
        getText() methodu bu durumlarda çalışmaz.

        5-Selenium da click yaparken problem yaşadığın oldu mu?
        Bazen yanlış locator, yada bekleme problemi gibi durumlarda problem yaşadım.
        Bazen gizli(hidden) elementlere tıklarken de problem yaşadım. Bu durumlarda
        Javascript executor kullandım ve problemi çözdüm.

        6-Selenium otomasyonunda ne tür problemler yaşadın?
        a)TEKNİK PROBLEMLER: Yanlış locator, bekleme(wait), alert, iframe, pop-up şeklindeki reklam bildirimleri
        multiple window, hidden elementlere tıklama...
        b)TAKIMLA İLGİLİ PROBLEMLER: (Çok gündeme getirilmemeli) Developer bazen bulduğum bugları kabul etmiyordu.
        Çözüm: takımla beraber değerlenidirip fikir birliğine varıyorduk..


     */

//    	1)getValueTest metotu olustur
//	    2)https://www.priceline.com/ a git
//      3)Tarih kısmındaki Yazili metinleri al ve yazdır

    @Test
    public void getValueTest() throws Exception {

//    	1)getValueTest metotu olustur
//	    2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");
//      3)Tarih kısmındaki Yazili metinleri al ve yazdır
        getValueByJS("hotelDates");

    }


}
