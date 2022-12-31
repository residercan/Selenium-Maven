package Examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Example04 {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));

    }

    @Test
    public void test01() throws Exception {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Books" secenegini secin
        //dropdown 3 adımda handle edilir
        //1- locate edilmeli
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2-Select objesi olusturulmalı
        Select select=new Select(ddm);
        //3-opsiyon secilir
        select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks");
        //select.selectByIndex(12);
        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin
        String sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(sonuc.contains("Java"));
    }



}
