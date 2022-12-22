package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_BeforeClassAfterClass {

    /*
        @BeforeClass ve @AfterClass methodları sadece static method'lar için çalışır.
    @BeforeClass ve @AfterClass kullanırsak oluşturduğumuz @Test methodlarının hepsini aynı anda çalıştırıp
    en son @AfterClass'ı çalıştırırız.
        Ama sadece @Before ve @After kullanırsak her test için @before ve @After'ı kullanır.
     */



    @BeforeClass
    public static void setUp() {
        System.out.println("Bütün testlerden önce çalıştı.");
    }




    @AfterClass
    public static void tearDown() {
        System.out.println("Bütün testlerden sonra çalıştı.");
    }

    @Before
    public void setUp01() {
        System.out.println("Her testten önce çalışır");
    }

    @After
    public void tearDown01() {
        System.out.println("Her testten sonra çalışır");
    }

    @Test
    public void test01() {
        System.out.println("İlk Test");
    }


    @Test
    public void test02() {
        System.out.println("İkinci Test");
    }

    @Test
    @Ignore("Çalışmasını istemediğimiz Teste Ignore ekleriz bu alanada açıklama yazabiliriz")
    public void test03() {
        System.out.println("Ücüncü Test");
    }


}


