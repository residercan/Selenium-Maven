package Examples;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Example07 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

     //   go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
     //   click  "Alert with OK"
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
     //   "click the button to display an  alert box: 'a tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
     //   accept Alert(I am an alert box!) and print alert on console
        driver.switchTo().alert().accept();
     //   Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
     //   click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
     //   "Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
     //   cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
     //   Alert'ü kapatın
     //   click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
     //   "Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
     //   and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
     //   Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        String actualResult = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        Assert.assertTrue(actualResult.contains("TechProEducation"));
     //   Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
     //   finally print on console this mesaaje "Hello TechProEducation How are you today"
        Assert.assertEquals("Hello TechProEducation How are you today", actualResult);

    }


}
