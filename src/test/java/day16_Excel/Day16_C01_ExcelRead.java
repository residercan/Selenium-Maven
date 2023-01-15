package day16_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day16_C01_ExcelRead {


    @Test
    public void excelReadTest() throws Exception {

//        WORKBOOK > WORKSHEET/SHEET > ROW(SATIR) > CELL(VERİ HÜCRESİ)

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

//        İLK SATIRDAKİ İLK VERİYİ AL
        Cell cell1 = row1.getCell(0);//İLK HÜCREDEKİ DATAYI VER

//        O VERİYİ YAZDIR
        System.out.println(cell1);

//        1. Satır 2.Sütun
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));


//        3. Satır 1. Sütun yazdır ve o verinin France olduğunu test et
        String cell31 = sheet1.getRow(2).getCell(0).toString();//toString methodu ile stringe çeviririz.
        System.out.println(cell31);
        Assert.assertEquals("France", cell31); //Stringe çevirerek Assert ile test edebiliriz.

//        Excel'deki toplam kullanılan satır sayısını bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1;//son satır numarası - int return eder.
        System.out.println(toplamSatirSayisi);//10 - index 0'dan başlayarak saydığı için 10+1 ekleyeceğiz

//        Kullanılan toplam satır sayısını bul
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();//kullanılan satır sayısını bize veriyor
        System.out.println(kullanilanToplamSatirSayisi);//1'den başlıyor o yüzden +1 eklememize gerek yok

//        COUNTRY - CAPİTAL key ve valueları map'a alıp print et
//        {{USA, D.C},{France, Paris}} gibi

//        Variable oluşturalım. Bu variable exceldeki country, capital verilerini tutacak
        Map<String, String> ulkeBaskentleri = new HashMap<>();
        for (int i=1; i<sheet1.getPhysicalNumberOfRows(); i++) {
            String country = sheet1.getRow(i).getCell(0).toString();
            String capital = sheet1.getRow(i).getCell(1).toString();
            ulkeBaskentleri.put(country, capital);
//        ulkeBaskentleri.put(sheet1.getRow(i).getCell(0).toString(),sheet1.getRow(i).getCell(1).toString());Tek satırda da yazabiliriz.
        }
        System.out.println(ulkeBaskentleri);

    }



}
