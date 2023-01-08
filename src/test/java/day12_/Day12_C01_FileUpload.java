package day12_;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day12_C01_FileUpload extends TestBase {


    @Test
    public void FileUpload() {


//        Tests packagenin altina bir class oluşturun : C05_UploadFile
//        https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
//        chooseFile butonuna basalim
        WebElement choseFileButton = driver.findElement(By.xpath("//*[@id='file-upload']"));
//        Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";
        /*
        chooseFileButton'una yüklemek istediğim dosyanın pathini göndrerek dosyayi seçtim.
         */
        choseFileButton.sendKeys(dosyaYolu);
        waitFor(5);

//        Upload butonuna basalim.

        WebElement upload = driver.findElement(By.xpath("//*[@id='file-submit']"));
        upload.click();
//        “File Uploaded!” textinin goruntulendigini test edelim.
        String actualText = driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText();
        Assert.assertEquals("File Uploaded!", actualText);

    }


}
