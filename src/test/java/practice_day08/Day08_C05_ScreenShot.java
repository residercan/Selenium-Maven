package practice_day08;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;

public class Day08_C05_ScreenShot extends TestBase {

    //Amazon sayfasına gidelim
    //Tüm sayfanın resmini alalım
    //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
    //Tekrar amazon sayfasına dönüp iphone aratalım
    //Arama sonucunun resmini alalım

    @Test
    public void screenShotTest() throws Exception {

        //Amazon sayfasına gidelim
        driver.get("http://www.amazon.com");
        //Tüm sayfanın resmini alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("src/test/java/resources.jpeg"));
        /*
        FİLEUTİLS CLASS'I, FİLE NESNELERİ İLE BİRLİKTE KULLANABİLECEĞİMİZ METHODLAR İÇERİR.
        BU METHODLARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA İŞLEMLERİNİ ÇOK DAHA KOLAY YAPABİLİRİZ.
         */
        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        //Tekrar amazon sayfasına dönüp iphone aratalım
        //Arama sonucunun resmini alalım



    }



}
