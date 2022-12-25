package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example03 {


    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }

    @Test
    public void test01() {

//  1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
//  2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user", Keys.ENTER);
//  3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce", Keys.ENTER);
//  4. Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
//  5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrunText = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        driver.findElement(By.xpath("//*[@class='inventory_item_name']")).click();
//  6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
//  7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
//  8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepeteEklenenUrun = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();

        if (sepeteEklenenUrun.equals(ilkUrunText)){
            System.out.println("Sepet testi passed");
        } else System.out.println("Sepet testi failed");

    }
    @After
    public void teardown() {
        //  9. Sayfayi kapatin
        //driver.close();
    }

}
