package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day01_C05 {

    static WebDriver driver;

    //BeforeClass ile driverı olusturun ve
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Maximize edin, 15 sn bekletin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
    }


    @Before
    public void setup () {
        //http://www.google.com adresine gidin
        driver.get("https://www.google.com/");
    }


    @Test
    public void test01() {
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin

//        WebElement sonuc = driver.findElement(By.xpath("//*[@id='result-stats']"));
//        System.out.println("Sonuc = " + sonuc.getText());
    }

    @Test
    public void test02() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
        }

    @Test
    public void test03(){
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill", Keys.ENTER);
        }

    @After
    //cikan sonuc sayisini yazdirin
    public void teardown(){
            String[] sonucList = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
            System.out.println(sonucList[1]);
        }


    @AfterClass
    //AfterClass ile kapatın
    public static void afterClass() {
        driver.quit();
    }



}
