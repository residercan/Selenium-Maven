package day06_Handle_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day06_Dropdown {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void selectByIndexTest(){
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        // Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


        //YIL SEÇİMİ
        //1. Locate dropdown element
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        //2. Select objesi oluştur
        Select selectYear = new Select(year);
        //3. Select objesini kullanarak 3 farklı şekilde seçim yapabilirim.
        //selectByIndex ile oluşturuyoruz
        selectYear.selectByIndex(22);//Seçenek sırası 0 yazarsak 2022, 1 yazarsak 2021 şeklinde devam eder. 2000 yılı 23. sırada index 0'dan başladığı için 22 yazdık.

        //AY SEÇİMİ
        //1. Locate dropdown element
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        //2. Select objesi oluştur
        Select selectMonth = new Select(month);
        //selectByValue ile oluşturuyoruz
        selectMonth.selectByValue("0");// manuel olarak value değerine bakılır ve String kabul ettiği için "" içerisinde değeri yazılır.

        //GÜN SEÇİMİ
        //1. Locate dropdown element
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        //2. Select objesi oluştur
        Select selectDay = new Select(day);
        //3. selectByVisibleText ile oluşturuyoruz.
        selectDay.selectByVisibleText("10");//Site ne yazıyorsa direk onu yazıyoruz. En sık kullanılan methoddur Büyük küçük harf duyarlıdır. String döndürdüğü için "" içerisinde yazarız.

    }
        @Test
        public void printAllTest (){
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
            //tüm eyaletleri print edelim

            WebElement eyaletler = driver.findElement(By.xpath("//*[@id='state']"));
            Select selectEyaletler = new Select(eyaletler);
            List<WebElement> tumEyaletlerListesi = selectEyaletler.getOptions();

            tumEyaletlerListesi.stream().forEach(t-> System.out.println(t.getText()));// Lambda ile çözüm
//            for(WebElement w : tumEyaletlerListesi){ //For each loop ile çözüm
//                System.out.println(w.getText());
//            }

        }

        @Test
        //Bir seçeneğin seçilip seçilmediğini nasıl otomate edebiliriz.
        public void getSelectedOptionsTest() {
            //Eyaleterin bulunduğu bölümdeki seçeneğin Select a State olduğunu otomate edelim.
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
            WebElement eyaletler = driver.findElement(By.xpath("//*[@id='state']"));
            Select selectEyaletler = new Select(eyaletler);
            String actualText = selectEyaletler.getFirstSelectedOption().getText();
            String expectedText = "Select a State";
            Assert.assertTrue(actualText.equals(expectedText));

        }

        @After
        public void tearDown() {
            driver.close();
        }



        /*
                    İNTERWİEV QUESTİONS
        1. What is dropdown? Dropdown nedir?
        -Dropdown lise oluşturmak için kullanılır
        2. How to handle dropdown elements? Dropdown nasıl automate edilir?
        -dropdown'ı locate ederim
        -select objesi oluştururum
        -select objesi ile istediğim seçeneği seçerim
        NOT: Select objesi oluşturma nedenim dropdown'ların Select classı ile oluşturulması.
        3. Tüm dropdown seçeneklerini nasıl print ederiz(konsolda yazdırırız)?
        -tüm dropdown elementlerini getOptions() methodu ile listeye koyarız.
        -sonra seçenekleri for loop ile yazdırabiliriz.
        4. Bir seçeneğin seçili olduğunu otomate etmek için ne yapılır.
        Örnek: gün olarak 10 u seçtik ama ya seçilmediyse?
        getFirstSelectedOption() methodu seçili olan seçeneği return eder.
         */







}
