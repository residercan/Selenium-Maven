package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example02 {


    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
    }


    @Test
    public void test01 () throws InterruptedException {


//  1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//  2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
//  3. Login alanine  "username" yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
//  4. Password alanine "password" yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
//  5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();
//  6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
//  7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("10");
//  8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        Thread.sleep(2000);
//  9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
//  10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        WebElement actualMessage = driver.findElement(By.xpath("//*[@id='alert_content']"));
        String expectedMessage = "The payment was successfully submitted.";

        if(actualMessage.getText().equals(expectedMessage)){
            System.out.println("Message testi passed");
        } else System.out.println("Message testi failed");

    }

    @After
    public void teardown(){
        driver.close();
    }

}
