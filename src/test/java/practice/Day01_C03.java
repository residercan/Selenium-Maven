package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day01_C03 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));



    // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    // Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//*[@id='calculatetest']")).click();
    // Type any number in the first input
        driver.findElement(By.xpath("//*[@id='number1']")).sendKeys("10",
                Keys.TAB, Keys.TAB, "10",     // Type any number in the second input
                Keys.TAB, Keys.ENTER); // Click on Calculate
    // Print the result
        WebElement result = driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println(result.getText());
        // close driver
        //driver.close();



    }
}
