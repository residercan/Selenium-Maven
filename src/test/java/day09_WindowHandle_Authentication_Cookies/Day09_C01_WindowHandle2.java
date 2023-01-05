package day09_WindowHandle_Authentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day09_C01_WindowHandle2 extends TestBase {

//        https://the-internet.herokuapp.com/windows adresine gidin.
//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//        Click Here butonuna basın.
//        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String windowHandle1 = driver.getWindowHandle();
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        Assert.assertEquals("Opening a new window", actualWindow1Text);
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualWindowTitle = driver.getTitle();
        Assert.assertEquals("The Internet", actualWindowTitle);
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        waitFor(3);
        //BURDAN SONRA IKINCI PENCERE ACILIR VE IKINCI PENCEREDE İSLEM YAPMAK ISTEDİĞİMDEN O PENCEREYE GEÇİS YAPILIR.
        switchToWindow(1);
        //switchToWindow("New Window");
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        System.out.println(driver.getTitle());
        String actualWindowTitle2 = driver.getTitle();
        Assert.assertEquals("New Window", actualWindowTitle2);
    }



}
