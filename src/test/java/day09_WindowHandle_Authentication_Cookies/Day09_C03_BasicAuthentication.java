package day09_WindowHandle_Authentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day09_C03_BasicAuthentication extends TestBase {


//https://the-internet.herokuapp.com/basic_auth sayfasina gidin
//asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//URL              : https://username:password@URL
//Username    : admin
//password    : admin
//Basarili sekilde sayfaya girin ve ‘Congratulations!’ yasizini doğrulayın


    @Test
    public void test01() throws Exception {

//    AUTHENTICATION URL'İMİZ:https://admin:admin@the-internet.herokuapp.com/basic_auth
//    https://--URL'in bu bölümüne kullanıcı adı : şifreyi girerek işlem yapabiliyoruz------the-internet.herokuapp.com/basic_auth

    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    waitFor(3);
    String actualText = driver.findElement(By.xpath("//p")).getText();
    String expectedText = "Congratulations!";
    Assert.assertTrue(actualText.contains(expectedText));

    }



}
