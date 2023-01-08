package utilities;

public class ActionsDersNotlari {


    //1-Actions nedir?
    //Actions seleniumdan gelen bir kütüphanedir.
    //Mouse ve Keyboard işlemlerini gerçekleştirmek için kullandığımız hazır bir selenium kütüphanesidir.
    //Örneğin, sağ tıklamak(contextClick), çift tıklamak(doubleClick), mouse elementin üzerinde tutmak(moveToElement)
    //gibi mouse işlmelerini gerçekleştirebiliriz. Aynı zamanda shift, control, delete, enter gibi keyboard tuşlarınada
    //actions yardımıyla basabiliriz. Bu tür işlemlerde sendKeys methodu kullanılır.




    //ACTIONS CLASS'ı NEDİR? HANGİ METHODLAR İLE  NASIL KULLANILIR?..

//   Actions classını kullanarak klavye ve mouse ile yapabileciğiz tüm işlemleri otomosyonda da  yapmamızı sağlamaktayız..!!
//   Bu classa ait metdodlar kısaca aşağıdaki gibidir....

//       actions.doubleClick () :   WebElement'e çift tıklama yapar
//       actions.clickAndHold () :  Uzerinde click yapili olarak bekler
//       actions .dragAndDrop () :  Bir noktadan diğerine sürükler ve bırakır
//       actions.moveToElement () : Mouse'u istedigimiz WebElement'in uzerinde tutar
//       actions.contextClick ():   Mouse ile istedigimiz WebElement'e sag tiklama yapar.
//       actions.sendKeys() :       Öğeye bir dizi anahtar gönderir
//       actions.keyDown () :       Klavyede tuşa basma işlemi gerçekleştirir
//       actions.keyUp () :         Klavyede tuşu serbest bırakma işlemi gerçekleştirir
//
//
//        !!!!Actions classını kullanmak için üç aşama vardır.

//     1.Action classından obje üretiriz.
//     (Actions actions= new Actions(driver);)
//     2.actions objesi ile kullanacağımız web elementi locate ederiz...
//     3.istediğimiz methodları action objesi ile kullanırız.
//     actions.doubleClick(element ismi).perform;
}
