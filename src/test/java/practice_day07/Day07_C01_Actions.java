package practice_day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day07_C01_Actions extends TestBase {


    /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    - Çizimden sonra clear butonuna basalım
    - Son olarak sayfayı temizleyiniz
     */

    @Test
    public void actionTest() throws Exception {

//        - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
//        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        WebElement canvas = driver.findElement(By.xpath("//canvas"));
        actions.moveToElement(canvas).clickAndHold();

        for (int i = 0; i <10; i++){
            actions.moveByOffset(5,5);
        }

        for (int i = 0; i < 10; i++){
            actions.moveByOffset(-10,-10);
        }

        for (int i = 0; i< 10; i++){
            actions.moveByOffset(20,20);
        }

        actions.release().build().perform();

        waitFor(5);
//        - Çizimden sonra clear butonuna basalım
        driver.findElement(By.xpath("//button[.='Clear']")).click();

    }


}
