package day07_Alert_Iframe_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class Day07_TestBaseDemo extends TestBase {

    /*
    UTILITIES:
    -Utilities tekrar tekrar kullanacağımız methodları veya classları koyduğumuz paketin adıdır.
        -TestBase --> Bugün
        -Driver --> Sonra
        -ExcelUtil --> Sonra
        -Configuration --> Sonra
    -Utilities paketinde Test Case'ler yazılmaz.
    -Sadece tekrar tekrar kullanılabilecek destek sınıfları(support class) oluşturulur.
    -Bu support classlar test caselerin yazılmasını hızlandırır.
     */


    @Test
    public void test01() {
//        techproeducation ana sayfasına git
//        ve title'ın Bootcamps kelimesini içerdiğini test edelim
        driver.get("https://www.techproeducation.com/");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Bootcamps"));
    }

}
