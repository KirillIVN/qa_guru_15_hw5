package topmail.kz.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import topmail.kz.pages.RegistrationFormPage;



public class RegistrationFormWithPageObjectsTeste {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        //test for main page;
        registrationFormPage.openPage()
                .setFirstName("Robert")
                .setLastName("Svan")
                .setEmail("r.sv@gmail.com")
                .setGender()
                .setPhoneNumber("8097545152")
                .setBirthDate("04", "7", "1975")
                .setSubject("Accounting")
                .setSubject("English")
                .setHobbies()
                .loadPicture()
                .setCurrAddress("Current Address 1")
                .setState()
                .setCity()
                .clickSubmitButton();

        //test for modal page;
        registrationFormPage.checkResultTableVisible()
                .checkResult("Student Name", "Robert Svan")
                .checkResult("Student Email", "r.sv@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8097545152")
                .checkResult("Date of Birth", "04 August,1975")
                .checkResult("Subjects", "Accounting, English")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "cat1.jpg")
                .checkResult("Address", "Current Address 1")
                .checkResult("State and City", "Haryana Panipat");
    }

}
