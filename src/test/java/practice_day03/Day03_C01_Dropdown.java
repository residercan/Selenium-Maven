package practice_day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Day03_C01_Dropdown extends TestBase {

    @Test
    public void test01(){
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com/");

        //1.YOL
        //Dropdown menüyü yazdıralım
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));

        dropdown.forEach(t-> System.out.println(t.getText()));
        //Dropdown menüden baby'i seçelim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB,
                "Milk", Keys.ENTER);//arama bölümünden milk aratalım

        //2.YOL
        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown1);
        for(WebElement w: select.getOptions()){
            System.out.println(w.getText());
        }
        select.selectByVisibleText("Baby");

    }



}
