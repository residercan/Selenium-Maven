package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_MavenIkinciTest {

    public static void main(String[] args) {


    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


    //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
    //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
    //3.Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
    //4.Password alanine “password” yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
    //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();//Sayfa hata verdiği için geri git diyoruz.
    //-Online Banking butonuna basınız sonra Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
    //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
    //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("10");
    //8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
    //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
    //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement actualMessage = driver.findElement(By.xpath("//*[@title='$ 10 payed to payee sprint']"));

        if(actualMessage.isDisplayed()){
            System.out.println("Message testi Passed");
        } else System.out.println("Message testi Failed");


        driver.close();

    }

}
