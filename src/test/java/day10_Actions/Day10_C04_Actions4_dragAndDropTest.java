package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day10_C04_Actions4_dragAndDropTest extends TestBase {


    @Test
    public void dragAndDropTest() throws Exception {
//        EN FAZLA KULLANILAN METHOD "dragAndDrop()" METHODUDUR.
//        Class: Action4
//        Method: dragAndDropTest
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);
//        Kaynak ve hedef elementleri iframenin içinde olduğu için
//        iframenin içine giriyoruz.
        driver.switchTo().frame(0);

        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

//        And user moves the target element(Drag me to my target) in to  destination(Drop here)

//        kaynak elementini mouse ile hedef elementinin üzerine sürükledik.
        actions.dragAndDrop(kaynak, hedef).perform();

    }


    @Test
    public void clickAndHoldTest(){

//        Aynı işlemi farklı yolla (clickAndHold ile) yapacağız.
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);
//        Kaynak ve hedef elementleri iframenin içinde olduğu için
//        iframenin içine giriyoruz.
        driver.switchTo().frame(0);

        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

//        clickAndHold yöntemi ile de kaynağı hedefe sürükleme işlemi yapıyoruz.
        actions
                .clickAndHold(kaynak)//kaynağı tut
                .moveToElement(hedef)//hedefe koy
                .release()//kaynağı bırak demek
                .build()//onceki methodlarin ilişkisini kur/guclendir. Kullanılması tercih edilir.
                .perform();//işlemi gerçekleştir

    }

    @Test
    public void moveByOffSetTest(){

//        Aynı işlemi farklı yolla (moveByOffSet ile) yapacağız.
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);
//        Kaynak ve hedef elementleri iframenin içinde olduğu için
//        iframenin içine giriyoruz.
        driver.switchTo().frame(0);

        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));


        actions
                .clickAndHold(kaynak)//Kaynağı tut
                .moveByOffset(430, 30)//Söylenilen koordinata götür
                .release()//Kaynağı bırak
                .build()//onceki methodlarin ilişkisini kur/guclendir.
                .perform();//işlemi gerçekleştir.

    }




}
