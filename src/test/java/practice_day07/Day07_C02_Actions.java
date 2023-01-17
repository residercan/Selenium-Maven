package practice_day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Day07_C02_Actions extends TestBase {


    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sarı olduğunu test edelim
     */


    @Test
    public void actionTest() throws Exception {

//        -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        Actions actions = new Actions(driver);
        WebElement green = driver.findElement(By.xpath("//*[@id='green']"));
        actions.moveToElement(green).clickAndHold().dragAndDropBy(green, -140, 0).release().build().perform();
        WebElement blue = driver.findElement(By.xpath("//*[@id='blue']"));
        actions.moveToElement(blue).clickAndHold().dragAndDropBy(blue, -140, 0).release().build().perform();
        actions.moveToElement(green).clickAndHold().dragAndDropBy(green, 280,0).release().build().perform();

//        -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız

//        -Sarı olduğunu test edelim
        WebElement yellow = driver.findElement(By.xpath("//*[@id='swatch']"));
        assert yellow.isDisplayed();


    }
}
