package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class HomeWork_01 extends TestBase {


    @Test
    public void test01() throws InterruptedException {
//    https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        String windowHandle1 = driver.getWindowHandle();
//    Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals("Windows", driver.getTitle());
//    Click here a tiklayin
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
//    Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> allWindowHandle = driver.getWindowHandles();
        for (String eachhandle : allWindowHandle){
            if (!eachhandle.contains(windowHandle1)){
                driver.switchTo().window(eachhandle);
                break;
            }
        }
        Assert.assertEquals("New Window", driver.getTitle());
        String windowHandle2 = driver.getWindowHandle();
        System.out.println(windowHandle2);
        System.out.println(windowHandle1);

        Thread.sleep(3000);
        driver.switchTo().window(windowHandle1);
        Thread.sleep(3000);
        driver.switchTo().window(windowHandle2);

    }

}
