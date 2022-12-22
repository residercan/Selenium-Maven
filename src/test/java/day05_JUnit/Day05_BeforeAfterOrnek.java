package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_BeforeAfterOrnek {

    WebDriver driver;

    /*
    @Before notasyanunun kullanildigi method'a genelde setup( ) ismi verilir.
    @after notasyanunun kullanildigi metoda genelde teardown() ismi verilir
    */

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://amazon.com/");
    }

    @Test
    public void test02() {
        driver.get("https://techproeducation.com");
    }


}
