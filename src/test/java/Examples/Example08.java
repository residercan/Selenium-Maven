package Examples;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Example08 extends TestBase {

    @Test
    public void test01() {

//https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        String windowHandle1 = driver.getWindowHandle();
        System.out.println(windowHandle1);
//Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String actualText = driver.findElement(By.xpath("//div[.='Please select an item from left to start practice.']")).getText();
        Assert.assertEquals("Please select an item from left to start practice.", actualText);
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();
//New Tab butonunun görünür olduğunu doğrula
        driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed();
//New Tab butonuna click yap
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        switchToWindow(1);
        driver.findElement(By.xpath("//*[@id='sampleHeading']")).isDisplayed();
//İlk Tab'a geri dön
        driver.switchTo().window(windowHandle1);
//New Tab butonunun görünür olduğunu doğrula
        driver.findElement(By.xpath("//*[@id='tabButton']")).isDisplayed();




    }


}
