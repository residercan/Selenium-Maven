package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Day05_C06_Actions extends TestBase {


    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    ////New Tab butonunun görünür olduğunu doğrula


    @Test
    public void test01 () throws Exception {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        WebElement alertsFrameWindows = driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]"));
        alertsFrameWindows.click();
        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String actualText = driver.findElement(By.xpath("//div[.='Please select an item from left to start practice.']")).getText();
        Assert.assertTrue(actualText.contains("Please select an item from left to start practice."));
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[.='Browser Windows']")).click();
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab.isDisplayed());
        //New Tab butonuna click yap
        newTab.click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
//        switchToWindow(1);//bu yöntem TestBase'de oluşturduğumuz resuable method ile kısayoldan yaptığımız yöntem. Aşağıda uzun çözüm yolu var.
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        WebElement yeniSayfaText = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        Assert.assertTrue(yeniSayfaText.isDisplayed());
        //İlk Tab'a geri dön
//        switchToWindow(0);
        driver.switchTo().window(windowHandles.get(0));
        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());




    }
}
