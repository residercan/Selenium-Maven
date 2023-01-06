package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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



    @After
    public void tearDown(){
        waitFor(5);
        driver.quit();
    }



//    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet")
    public static void switchToWindow (String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //windowNumber sıfır (0)'dan başlıyor.
    //index numarasını parametre olarak alır.
    //ve o indexli pencereye geçiş yapar.
    public static void switchToWindow (int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }



    /*   HARD WAIT:
     @param : second
    */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
