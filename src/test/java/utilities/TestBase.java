package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //Test Base'i abstract yapmamızın sebebi bu sınıfın objesini oluşturmak istemiyorum.
    //TestBase testBase = new TestBase(); -> Yapılamaz
    //Amacım bu sınıfı extend etmek ve içindeki hazır methodları kullanmak

    // driver objesini oluştur. Driver ya public yada protected olmalı.
    // Sebebi child classlarda görülebilir olması
        protected  static WebDriver driver;


    // setUp
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    //teardown
    @After
    public void tearDown() {
        driver.quit();
    }

}
