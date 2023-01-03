package Examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Example06 extends TestBase {

    @Test
    public void test01() {

//  go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
//  maximize the web site
        driver.manage().window().maximize();
//  ikinci emojiye tıklayın
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
//  ikinci emoji altındaki tüm öğelere tıklayın
        WebElement emojiler = driver.findElement(By.tagName("img"));


//  ana iframe'e geri dön
//  formu doldurun,(Formu istediğiniz metinlerle doldurun)
//  uygula butonuna tıklayın

    }

}
