package day16_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Day16_C02_WriteExcel {

    /*
    Excel Okuma
    Excelden veriyi okumak icin hangi sırayla gitmem gerekir
    workbook > sheet > row > cell
    Bir exceldeki top satir sayısı nasıl bulunur?
    getLastROwNumber
            Yada
    getPhysicalNumberOfRows- toplam kullanılan satir sayısı
    Excel Yazdırma
    Microsoft dosyalari ile iletişime gecmek icin apache poi dependency’s kullanılır
    Su anki projende exceli nasil kullandin?
    Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz. Bu datalari test caselerde kullanmak icin excelden çekiyorum ve test caselerimde kullanıyorum.
    Datalari excelde tutmanı faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.
    */



    @Test
    public void writeExcelTest() throws Exception {

//        WORKBOOK > SHEET > ROW > CELL > YAZDIR > KAYDET

        String path = "./src/test/java/resources/Capitals.xlsx";

//        DOSYAYI AÇ
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCEL DOSYASINI AC / WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);


//        SAYFAYI AC / SHEET 1
//        Sheet sheet1 = workbook.getSheetAt(0);//index 0'dan başlar. ilk sayfayı aç
        Sheet sheet1 = workbook.getSheet("Sheet1");//Sheet ismi ile de sayfayı açabiliriz. Sheet1 isimli sayfayı aç dedik.

//        İLK SATIRA GİT / ROW(SATIR)
        Row row1 = sheet1.getRow(0); //İLK SATIRA GİT

//        İlk satır 3. sütunu create et

        Cell cell3 = row1.createCell(2);

//        3. sütuna nüfus yazdıralım

        cell3.setCellValue("NUFUS");

//        Kaydet

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        Cell cell3Yazdir = row1.getCell(2);
        System.out.println(cell3Yazdir);


//        2. satır 3. sütuna 450000 yazdır
        sheet1.getRow(1).createCell(2).setCellValue("450000");

//        3. satır 3. sütuna 350000 yazdır
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        workbook.write(fileOutputStream);

    }








}
