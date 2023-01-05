package day09_WindowHandle_Authentication_Cookies;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Day09_C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() throws Exception {

//        Class: Cookies
//        Method: handleCookies
//        Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);
//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();// toplam cerez sayisi
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada " + cookieSayisi + " adet cookie var");

//        3. Bir Cookie yi ismiyle bul
        System.out.println("Cookie'yi ismiyle bul: "+driver.manage().getCookieNamed("session-id-time"));

//        Tüm cookie'leri yazdıralım
        //allCookies.stream().forEach(t -> System.out.println(t.getName()));
        for(Cookie eachCookie: allCookies){
            System.out.println("COOKIE : "+eachCookie);//Cookie'nin tüm bilgilerini yazdırır.
            System.out.println("Cookie İsimleri: " + eachCookie.getName());//.getName(); ile cookie isimlerini yazdırır.
        }

//        4. Yeni bir cookie ekle
        Cookie favoriCookie = new Cookie("cikolatam","antep-Fistikli-Cikolata");
        driver.manage().addCookie(favoriCookie);
        System.out.println(driver.manage().getCookies().size());
        waitFor(3);
//        5. Bir Cookieyi ismiyle sil
        driver.manage().deleteCookieNamed("cikolatam");
//        6. Tum cookieleri sil
        driver.manage().deleteAllCookies();



    }


}
