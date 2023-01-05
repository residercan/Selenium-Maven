package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Day04_C03_WindowHandleGecis extends TestBase {

    @Test
    public void test01() throws Exception {

        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textbox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textbox.clear();
        textbox.sendKeys("Techproeducation");
        String windowHandle1 = driver.getWindowHandle();
        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement elementel = driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']"));
        Assert.assertTrue(elementel.isDisplayed());
        // Elemental Selenium linkine tıklayın
        elementel.click();
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Açılan pencerelerin handle değerleri : "+windowHandles);
        driver.switchTo().window(windowHandles.get(1));
        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */
        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println(driver.getTitle());
        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sauceLabs = driver.findElement(By.xpath("//*[@class='link']"));
        Assert.assertTrue(sauceLabs.isDisplayed());
        // Source labs linkine tıklayın
        sauceLabs.click();
        List<String> allwindowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println(allwindowHandles);
        driver.switchTo().window(allwindowHandles.get(2));
        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println(driver.getTitle());
        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(windowHandle1);
        // ilk sekmeyi kapatalım
        driver.close();

    }
}
