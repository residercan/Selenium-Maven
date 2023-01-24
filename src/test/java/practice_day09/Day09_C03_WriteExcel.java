package practice_day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day09_C03_WriteExcel extends TestBase {



    @Test
    public void writeExcelTest() throws IOException {

        //Data isimli excel dosyasına yeni kullanıcı adı ve password ekliyelim
        String dosyaYolu = "C:\\Users\\Reşid Ercan\\Desktop\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1").createRow(3).createCell(0).setCellValue("email");
        workbook.getSheet("Sayfa1").createRow(3).createCell(1).setCellValue("abc@gmail.com");
        workbook.getSheet("Sayfa1").createRow(4).createCell(0).setCellValue("password");
        workbook.getSheet("Sayfa1").createRow(4).createCell(1).setCellValue("123456");
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
    }

    @Test
    public void writeExcelTest2() throws IOException {
        //Yeni bir methodda kullanıcı bilgileri başlığını silelim

        String dosyaYolu = "C:\\Users\\Reşid Ercan\\Desktop\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(0);
        row.removeCell(cell);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
    }


}

