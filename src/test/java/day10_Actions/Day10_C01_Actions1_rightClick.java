package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day10_C01_Actions1_rightClick extends TestBase {

    @Test
    public void rightClick() throws Exception {

//        Class: Actions1
//        Method: rightClick
//        1. ACTIONS OBJESİ OLUŞTUR
        Actions actions = new Actions(driver);
//        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        2. ELEMENTI LOCATE EDELİM
        WebElement kutu = driver.findElement(By.xpath("//*[@id='hot-spot']"));

//        Kutuya sag tıklayın
//        Tüm actionslar actions objesiyle başlar ve perform ile biter.
//        contextClick ile sağ tıklıyoruz.
        actions.contextClick(kutu).perform();
//        Alert’te cikan yazinin “You selected a context menu” oldugunu
//        test edin
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", actualText);
//        Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();




    }



}
