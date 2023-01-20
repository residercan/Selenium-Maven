package day17_Javascript_Executors;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day17_C02_JSExecutor_Click extends TestBase {

//    clickByJSTest
//    Techpro education ana sayfasina git
//    LMS LOGIN elementine tikla
//    Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et


    @Test
    public void clickByJSTest() throws Exception {

//    clickByJSTest
//    Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
//    LMS LOGIN elementine tikla
        WebElement lmsLogin = driver.findElement(By.xpath("(//*[@href='https://lms.techproeducation.com/'])[2]"));
        clickByJS(lmsLogin);
        waitFor(3);
//    Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        Assert.assertEquals("https://lms.techproeducation.com/", driver.getCurrentUrl());






    }

}
