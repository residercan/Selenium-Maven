package day06_Handle_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day06_DropdownReusableMethod {

    //-------REUSABLE METHOD--------//

    WebDriver driver;

    @Before
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    //Reusable Method: Dropdown için tekrar tekrar kullanabileceğimiz methodlar oluşturalım.
    public void selectFromDropdown (WebElement dropdown, String text) {
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005"); -> year dan 2005
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")), "January"); -> month January
//        selectFromDropdown(driver.findElement(By.id("day")), "12"); -> Day 12

    List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum option tagli elementleri alıyorum
        for(WebElement eachOption: options){
            if(eachOption.getText().equals(text)){
                eachOption.click();
                break;
            }
        }
    }

    @Test
    public void selectFromDropdown(){
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005");//2005 i secti
        selectFromDropdown(driver.findElement(By.id("month")),"November");
        selectFromDropdown(driver.findElement(By.id("day")),"10");
        selectFromDropdown(driver.findElement(By.id("state")), "Texas");


    }

}

