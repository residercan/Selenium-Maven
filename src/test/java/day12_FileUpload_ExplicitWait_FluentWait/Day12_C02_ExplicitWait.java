package day12_FileUpload_ExplicitWait_FluentWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Day12_C02_ExplicitWait extends TestBase {



    @Test
    public void explicitWaitTest() {

//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        IMPLICIT_WAIT İLE TEST CASE ÇALIŞMADI
//        1. WebDriverWait objesini oluştur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        2. wait objesini kullanarak bekleme problemini çözmeye çalış
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

//        Hello World! Yazının sitede oldugunu test et
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!", helloWorldText);





    }
}
