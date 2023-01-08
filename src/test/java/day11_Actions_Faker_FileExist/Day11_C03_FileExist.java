package day11_Actions_Faker_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day11_C03_FileExist extends TestBase {


    @Test
    public void isExistTest() {

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME);

        //logo.jpeg indirip masaüstüne kaydedin

        String dosyaYolu = userHOME + "/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));//dosya var ise true, yok ise false return edecek
        Assert.assertTrue(isExist);

    }

        @Test
        public void isExist() {

//            Class : FileDownloadTest Method : downloadTestExist
//            https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
            driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
//            b10 all test cases dosyasını indirelim
            driver.findElement(By.xpath("//*[.='b10 all test cases, code.docx']")).click();
            waitFor(3);
//            Dosyanın başarıyla indirilip indirilmediğini test edelim
            String userHOME = System.getProperty("user.home");
            System.out.println(userHOME);

            boolean isExist = Files.exists(Paths.get(userHOME + "/Downloads/b10 all test cases, code.docx"));
            Assert.assertTrue(isExist);

        }
}
