package day12_;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class Day12_C03_FluentWait extends TestBase {


    @Test
    public void fluentWait() {

//        EXPLİCİT WAİT İLE AYNI SORUYU FLUENT WAİT İLE ÇÖZÜYORUZ.
//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        IMPLICIT_WAIT İLE TEST CASE ÇALIŞMADI
//        EXPILICIT WAIT İLE FLUENT WAIT ARASINDAKİ TEK FARK BU KISIMDIR.
//        1. FluentWait için obje oluştur.
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))//Maximum bekleme süresi
                .pollingEvery(Duration.ofSeconds(3))//Deneme aralıkları
                .withMessage("Ignore Exception")//Mesaj yazdırılabilir. Zorunlu değil.
                .ignoring(NoSuchMethodException.class);//Exception'ı handle et. Zorunlu değil.

//        2. wait objesini kullanarak bekleme problemini çözmeye çalış

        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

//        Hello World! Yazının sitede oldugunu test et

        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!", helloWorldText);

    }






}
