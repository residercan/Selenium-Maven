package day11_Actions_Faker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day11_C02_JavaFaker {


    @Test
    public void javaFakerTest() {
//      1. Faker objesi oluştur
        Faker faker = new Faker();
//      2. Faker objesi ile fake data oluştur.
//      FirstName Datası
        String firstName = faker.name().firstName();
        System.out.println(firstName);
//      LastName Datası
        String lastName = faker.name().lastName();
        System.out.println(lastName);

//      Kullanıcı adı
        String username = faker.name().username();
        System.out.println(username);
//      Meslek ismi
        String meslek = faker.name().title();
        System.out.println(meslek);

//      Adres
        String adress = faker.address().fullAddress();
        System.out.println(adress);

//      Eyalet
        String eyalet = faker.address().state();
        System.out.println(eyalet);

//      Cep telefon numarası
        String phoneNumber = faker.phoneNumber().cellPhone();
        System.out.println(phoneNumber);

//      E-mail address
        String email = faker.internet().emailAddress();
        System.out.println(email);

//      rastgele 15 haneli numara
        System.out.println(faker.number().digits(15));

        /*
        Test Data: kullanıcı adı, şifre, tel no, email, şehir, kredi kartı bilgileri, kredi kartı no...
        Test dataları kimden alınır?
        1. BA-Business Analyst(Acceptance Criteria'ları yazar)
        2. Test Lead
        3. Manual Tester
        4. Tech Lead & Team Lead & Dev Lead
        5. Developer
        6. Database
        7. API Call'lar
        8. Documentation. Orneğin, API swagger dökümanı.
        9. Java Faker da fake data almak için kullanıyoruz.


        Nerden alınmaz? : kullanıcıdan, scrum master,

         */

    }



}
