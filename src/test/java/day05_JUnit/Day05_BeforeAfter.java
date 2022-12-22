package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Day05_BeforeAfter {

    /*
    @Before notasyanunun kullanildigi method'a genelde setup( ) ismi verilir.
    @after notasyanunun kullanildigi metoda genelde teardown() ismi verilir
    */

    @Before
    public void setUp() {
        System.out.println("Her Test Methodundan Önce Çalışır");
    }

    @After
    public void tearDown() {
        System.out.println("Her Test Methodundan Sonra Çalışır");
    }


    @Test
    public void test01() {
        //Before Çalışır
        System.out.println("İlk Test");
        //After Çalışır
    }


    @Test
    public void test02() {
        //Before Çalışır
        System.out.println("İkinci Test");
        //After Çalışır
    }








}
