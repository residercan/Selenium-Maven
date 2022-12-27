package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day01_C04 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        // Add Element butonuna 100 defa basınız
        WebElement addButon = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < 100; i++) {
            addButon.click();
        }
        // 100 defa basıldığını test ediniz
        List<WebElement> deleteButton = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100, deleteButton.size());
        // 90 defa delete butonuna basınız
        int counter = 0;//Alternatif yol olarak counter da kullanılabilir.
        for(int i=0; i<90; i++){
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
            counter++;
        }
        // 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(90, counter);


        // Sayfayı kapatınız


    }
}
