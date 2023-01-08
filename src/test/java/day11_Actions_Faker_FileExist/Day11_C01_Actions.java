package day11_Actions_Faker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day11_C01_Actions extends TestBase {



    @Test
    public void keyboardActionsTest() {

//        Create a class: Action5
//        Create a method keyboardActions
//        Google a gidin https://www.google.com
        driver.get("https://www.google.com");
//        ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
//        ‘cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
//        Ve ENTER tusuna bas
        Actions actions = new Actions(driver);
        WebElement search = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        actions
                .keyDown(search, Keys.SHIFT)//arama kutusunun üstünde Shift tuşuna bas
                .sendKeys("iPhone X fiyatlari")//shifte basılıyken yazı yaz
                .keyUp(search, Keys.SHIFT)//shift tusunu kaldır
                .sendKeys(" çok pahalı!", Keys.ENTER)//yazı yaz ve arama yap
                .build()//birden fazla actions methodu kullanıldığında kullanılması önerilir. yapıyı güçlendirir.
                .perform();//eylemleri tamamla

    }

}
