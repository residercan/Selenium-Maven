package practice_day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day08_C02_UploadFile extends TestBase {


    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin
    @Test
    public void name() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        //"C:\Users\Lenovo\OneDrive\Masaüstü\sen.txt" //DOSYANIN GERÇEK YOLUNU ALIP GÖREBİLMEK BURAYA KOYDUK
        //String farkliKisim = System.getProperty("user.home");//C:\Users\Lenovo
        //String ortakYol = "\\OneDrive\\Masaüstü\\sen.txt";
        //String dosyaYolu = farkliKisim+ortakYol;
        String dosyaYolu = "C:\\Users\\Reşid Ercan\\Desktop\\logo.jpeg";
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
        dosyaSec.sendKeys(dosyaYolu);
        // I accept terms of service bölümünü tikleyin
        WebElement checkBox =  driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB, Keys.ENTER);
        // Submit File buttonuna basınız
        WebElement checkbox =driver.findElement(By.xpath("//*[@id='submitbutton']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB, Keys.ENTER);
        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(3);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }


}
