package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day10_C03_Actions3_scrollUpDown extends TestBase {



    @Test
    public void scrollUpDown () throws Exception {


//        Class: ActionClass3
//        Method : scrollUpDown()
//        https://techproeducation.com a git
        driver.get("https://techproeducation.com");
        Actions actions = new Actions(driver);
//        Sayfanin altına doğru gidelim
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);

        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        //Arrow_Down Page_Down'dan daha az mesafe aldirir.
        //İkiside aynı işlemi yapar.
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(2);


//        Sonra sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);

        actions.sendKeys(Keys.ARROW_UP).perform();
        waitFor(2);

    }
}
