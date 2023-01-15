package day15_Extent;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day15_C03_WebTables extends TestBase {



    @Test
    public void webTablesTest() throws Exception {

//        https://the-internet.herokuapp.com/tables
//        Create a class: WebTables
        driver.get("https://the-internet.herokuapp.com/tables");
//        Task 1 : Table1’i print edin
        String table1 = driver.findElement(By.xpath("//*[@id='table1']")).getText();
        System.out.println(table1);
        //Aşağıdaki yöntemle List'e alarak elemanları tek tek alıyoruz.
        List<WebElement> tumveriler = driver.findElements(By.xpath("//*[@id='table1']//td"));
//        tumveriler.forEach(t-> System.out.println(t.getText())); //Lambda ile çözüm yolu
        for (WebElement veri : tumveriler) {
            System.out.println(veri.getText());
        }

    }
        @Test
        public void row3ElementTest() throws Exception {
        driver.get("https://the-internet.herokuapp.com/tables");
//        Task 2 : 3. Row’ datalarını print edin
        String row3 = driver.findElement(By.xpath("//*[@id='table1']//tbody//tr[3]//td")).getText();
        System.out.println(row3);

        List<WebElement> row3Elements = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr[3]//td"));
        row3Elements.forEach(t-> System.out.println(t.getText()));
        }

        @Test
        public void rowLastElementTest() {

        driver.get("https://the-internet.herokuapp.com/tables");

//        Task 3 : Son row daki dataları print edin
            String rowLast = driver.findElement(By.xpath("//*[@id='table1']//tbody//tr[last()]//td")).getText();
            System.out.println(rowLast);

            List<WebElement> rowLastElement = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr[last()]//td"));
            rowLastElement.forEach(t-> System.out.println(t.getText()));

        }


        @Test
        public void column5ElementTest () {

        driver.get("https://the-internet.herokuapp.com/tables");

//        Task 4 : 5. Column datalarini print edin
        String colum5 = driver.findElement(By.xpath("//*[@id='table1']//td[5]")).getText();
            System.out.println(colum5);

        List<WebElement> colum5Element = driver.findElements(By.xpath("//*[@id='table1']//td[5]"));
            for (WebElement veri: colum5Element){
                System.out.println(veri.getText());
            }
        }



        public void printData (int satir, int sutun) {

//        Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//        Parameter 1 = row numarasi
//        Parameter 2 = column numarasi
//        printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

            driver.get("https://the-internet.herokuapp.com/tables");
            String myXpath = "//*[@id='table1']//tbody//tr["+ satir + "]//td[" + sutun + "]";
            System.out.println(driver.findElement(By.xpath(myXpath)).getText());

        }

        @Test
        public void printDataTest(){
        printData(2,3);
        printData(1,2);
        printData(3,5);
        }




}
