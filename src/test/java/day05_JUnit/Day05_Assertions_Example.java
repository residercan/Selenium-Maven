package day05_JUnit;

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

import static com.google.common.base.Objects.equal;

public class Day05_Assertions_Example {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }


    //1)Bir class oluşturun:AmazonAssertions
    //2)https://www.amazon.com adresinegidin
    //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin

    @Test
    public void test01 () {

        //○ title Test  => Sayfa başlığının “YouTube” oldugunu testedin

        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    @Test
    public void test02 () {

            //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) testedin
        WebElement sayfaResmi = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }


    @Test
    public void test03 () {
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }



    @Test
    public void test04 () {

        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "amazon";
        Assert.assertFalse(actualTitle1.contains(expectedTitle1));


    }



}


