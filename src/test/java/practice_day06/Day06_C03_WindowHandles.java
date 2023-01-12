package practice_day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Day06_C03_WindowHandles extends TestBase {


    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'oppo' yazıp aratın
    // ilk ürüne tıklayın
    // Basligin 'Oppo' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void test01 () throws Exception {


        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("oppo", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();
        // Basligin 'Oppo' icerdigini test edin.
        List<String> allHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allHandles.get(1));
        String oppoBaslik = driver.findElement(By.xpath("//h1[@class='proName']")).getText();
        Assert.assertTrue(oppoBaslik.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(allHandles.get(0));
        String n11Title = driver.getTitle();
        System.out.println("n11Title = " + n11Title);


    }


}
