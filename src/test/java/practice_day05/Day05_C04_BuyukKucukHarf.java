package practice_day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day05_C04_BuyukKucukHarf extends TestBase {



    @Test
    public void test01() throws Exception {

        //google sayfasına gidelim
        driver.get("https://www.google.com");
        //büyük küçük harf olacak şekilde HeLlO yazdıralım
        WebElement aramaMotoru = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaMotoru.sendKeys(Keys.SHIFT, "h", Keys.SHIFT, "e", Keys.SHIFT, "l", Keys.SHIFT, "l", Keys.SHIFT, "o", Keys.SHIFT);



    }


}
