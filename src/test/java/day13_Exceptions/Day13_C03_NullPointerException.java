package day13_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Day13_C03_NullPointerException {

    /*
    NullPointerException
    Değişkenleri oluşturup instantiate etmediğimizde alırız.
    Örn: driver = new ChoromeDriver()'da "new" kelimesini kullanmadığımızda NullPointerException hatasını alırız.

    Çözüm
    WebDriver driver = new ChromeDriver();
    Faker faker = new Faker();
    new deyip atamaları yaptığımız zaman hata giderilir.

     */


    //TestBase'i extends etmiyoruz. Oradaki hazır kodları kullanmamak için
    //WebDriver driver = new ChromeDriver() yapmadığımız için NullPointerException hatasını alıyoruz.
    //atama yapılmadığı için sadece WebDriver driver; şeklinde bıraktığımız için NullPointerException hatasını alıyoruz.

    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest() {
//        driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com");//NullPointerException hatasını alıyoruz.

    }


    //Faker objesini oluşturup new Faker(); demediğimiz için NullPointerException hatasını alıyoruz.
    @Test
    public void nullPointerExceptionTest2() {
//        faker = new Faker();
        System.out.println(faker.name().fullName());//NullPointerException hatasını alıyoruz.

    }


}
