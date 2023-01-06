package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day10_C02_Actions2_moveToElement extends TestBase {


    @Test
    public void moveToElement () throws Exception {

        /*
    MANUAL:
    Amazon home sayfasina git
    Account & List e uzerinde bekle -mouse over - hover over
    Acilan pencerede Account linkine tikla
    Acilan sayfanin title inin Your Account oldugunu dogrula
        */

//        1. Actions Objesi oluştur.
        Actions actions = new Actions(driver);
//        Amazon'a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//        2. Elemanı Bul
//        Account & List e uzerinde bekle -mouse over - hover over
        WebElement accountList = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        waitFor(1);
        actions.moveToElement(accountList).perform();
        waitFor(3);
//        Acilan pencerede Account linkine tikla
        driver.findElement(By.xpath("//span[.='Account']")).click();
//        Acilan sayfanin title inin Your Account oldugunu dogrula
        String actualTitleAmazon = driver.getTitle();
        Assert.assertTrue(actualTitleAmazon.contains("Your Account"));

    }

}
