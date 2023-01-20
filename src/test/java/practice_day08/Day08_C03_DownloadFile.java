package practice_day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day08_C03_DownloadFile extends TestBase {


    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım


    @Test
    public void downloadFileTest() throws Exception {

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browser).perform();
        waitFor(5);
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        WebElement documentation = driver.findElement(By.xpath("(//*[.='documentation'])[5]"));
        documentation.click();
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        WebElement latestStable = driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]"));
        latestStable.click();
        //Açılan pencerede chromedriver'i indirelim
//        switchToWindow(1);
        List<String> windowsHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandles.get(1));
        WebElement chromeDriver = driver.findElement(By.xpath("//*[.='chromedriver_win32.zip']"));
        chromeDriver.click();
        waitFor(10);
        //Driver'in indiğini doğrulayalın
//        String dosyaYolu = "C:\\Users\\Reşid Ercan\\Downloads\\chromedriver_win32.zip";
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32.zip";
        assert Files.exists(Paths.get(dosyaYolu));


    }


}
