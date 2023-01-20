package day18_Javascript_Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class Day18_C02_Log4J {

    /*
    Log4j Nedir?
        Loglama yani yazdırma işlemi yapmak için kullanılan bir API'dır.
        Ceşitli seviyelerde loglama işlemi yapılabilir: uyarı, bilgi, debug, hata mesajları için kullanılabilir.
        Javadaki system.out.println'e benzer ama log4j ile dosyaya detaylı şekilde yazdırma işlemi yapılabilir.
        Şuanda projemde log4J2 kullanmaktayım.
     */








//      3. Logger object olustur:
//      private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//      4. Logger fonksiyonuyla istenilen fonksiyonu kullan
//        logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");

    private static Logger logger = LogManager.getLogger(Day18_C02_Log4J.class.getName());
    @Test
    public void log4JTest() throws Exception {

//      logger objesi ile yazdırma işlemini yap
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug !");
        logger.info("Info Log!");


    }



}
