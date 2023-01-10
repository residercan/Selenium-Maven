package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day05_C05_Actions extends TestBase {



//        -http://spicejet.com/ sayfasına gidelim
//        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
//        -Sayfa başlığının Fleet içerdiğini test edelim


    @Test
    public void test01 () throws Exception {

//        -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

//        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//div[.='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        WebElement fleet = driver.findElement(By.xpath("//div[.='Fleet']"));
        fleet.click();

//        -Sayfa başlığının Fleet içerdiğini test edelim
        switchToWindow(1);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Fleet"));



    }




}
