package day17_Javascript_Executors;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day17_C03_JSExecutor_Type extends TestBase {


//        1)typeTest metotu olustur
//        2)Techpro education ana sayfasina git
//        3)Arama kutusuna QA yaz


    @Test
    public void typeTest() throws Exception {

//        1)typeTest metotu olustur
//        2)Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
//        3)Arama kutusuna QA yaz
        typeWithJS(driver.findElement(By.xpath("//*[@title='Search']")),"QA");






    }
}
