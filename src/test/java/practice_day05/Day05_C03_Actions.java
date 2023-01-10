package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day05_C03_Actions extends TestBase {


    /*
                                    Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.

    */



//    http://uitestpractice.com/Students/Actions adresine gidelim
//    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
//    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
//    Accept ile alert'ü kapatalım
//    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin


    @Test
    public void test01() throws Exception {

//    http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");
//    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement maviKutu = driver.findElement(By.xpath("//*[@id='div2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(maviKutu).perform();
        waitFor(3);
//    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClickMe = driver.findElement(By.xpath("//button[.='Double Click Me !']"));
        actions.doubleClick(doubleClickMe).perform();
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!", actualText);
//    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();
//    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        actions.dragAndDrop(drag , drop).release().build().perform();
        waitFor(2);
        System.out.println(drop.getText());
        Assert.assertEquals("Dropped!", drop.getText());


    }


}
