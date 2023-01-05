package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Day04_C01_WindowHandle extends TestBase {

    @Test
    public void test01() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");
        //Sayfa’nin window handle degerini String bir degiskene atayin
        String windowHandleAmazon = driver.getWindowHandle();
        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));
        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//Yeni bir sekme açmış olduk
        driver.get("https://www.techproeducation.com/");
        String windowHandleTechPro = driver.getWindowHandle();
        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitleTechPro = driver.getTitle();
        Assert.assertFalse(actualTitleTechPro.contains("TECHPROEDUCATION"));
        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        String windowHandleWalmart = driver.getWindowHandle();
        //Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitleWalmart = driver.getTitle();
        Assert.assertTrue(actualTitleWalmart.contains("Walmart"));
        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(windowHandleAmazon);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.amazon.com/", actualUrl);

    }

}
