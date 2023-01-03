package practice_day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day03_C02_Alert extends TestBase {


    @Test
    public void test01() throws InterruptedException {

    //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
    //    accept Alert(I am an alert box!) and print alert on console
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();
        System.out.println(driver.switchTo().alert().getText());//Alert üzerindeki yazıyı konsola yazdırdık.
        driver.switchTo().alert().accept();//Alertte tamama bastık

    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
    //    cancel Alert  (Press a Button !)
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
    //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    //    finally print on console this message "Hello TechProEducation How are you today"
        String actualfinaly = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println(actualfinaly);
        String expectedfinaly = "Hello TechProEducation How are you today";
        Assert.assertEquals(expectedfinaly, actualfinaly);
    //    aseertion these message

    }
}
