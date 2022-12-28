package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day01_C02 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));


        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //fill the firstname
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys("M.Reşid",
                Keys.TAB, "Ercan", //fill the lastname
                Keys.TAB, Keys.ARROW_RIGHT, //check the gender
                Keys.TAB, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, //check the experience
                Keys.TAB, "27/12/2022", //fill the date
                Keys.TAB, Keys.TAB, Keys.SPACE, //choose your profession -> Automation Tester
                Keys.TAB, Keys.TAB,Keys.TAB, Keys.SPACE, //choose your tool -> Selenium Webdriver
                Keys.TAB, "Africa", //choose your continent -> Africa
                Keys.TAB, "Browser Commands", Keys.ENTER, //choose your command  -> Browser Commands
                Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER); //click submit button

    }



}
