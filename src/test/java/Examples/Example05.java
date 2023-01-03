package Examples;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class Example05 extends TestBase {


    @Test
    public void test01() {
//       url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
//       ilk pencereyi al
        String windowHandle1 = driver.getWindowHandle();
//       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
//       setteki tüm pencereyi al
        Set<String> allHandles = driver.getWindowHandles();
        for(String eachHandle : allHandles){
            if(!eachHandle.contains(windowHandle1)){
                driver.switchTo().window(eachHandle);
            }
        }
//       diğer pencereye geç
        String windowHandle2 = driver.getWindowHandle();
//       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com", Keys.ENTER);
//       Gönder düğmesine tıklayarak
//       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("This access is valid only for 20 days.", actualtext);
//       Tekrar ilk pencereye geç
        driver.switchTo().window(windowHandle1);
//       İlk pencerede olduğunu doğrula
        Assert.assertEquals(windowHandle1, driver.getWindowHandle());
    }


}
