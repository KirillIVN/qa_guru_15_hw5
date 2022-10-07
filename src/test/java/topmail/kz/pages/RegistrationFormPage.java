package topmail.kz.pages;

import com.codeborne.selenide.SelenideElement;
import topmail.kz.pages.components.CalendarComponent;
import topmail.kz.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private  SelenideElement
            firstNameInput = $x("//*[@id='firstName']"),
            lustNameInput = $x("//*[@id='lastName']"),
            emailInput = $x("//*[@id='userEmail']"),
            mobilePhoneInput = $x("//*[@id='userNumber']"),
            currentAddressInput = $x("//*[@id='currentAddress']"),
            buttonClick = $x("//*[@id='submit']");

    private final static String TITLE_TEXT = "Practice Form";

    //open main page;
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");

        return this;
        }

    //input First name
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    //input Last name
    public RegistrationFormPage setLastName(String value) {
        lustNameInput.setValue(value);

        return this;
    }
    //input Email name
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    //set Gender
    public RegistrationFormPage setGender() {
        $x("//*[@id='gender-radio-1']").parent().click();

        return this;
    }
    //input phone number
    public RegistrationFormPage setPhoneNumber(String value) {
        mobilePhoneInput.setValue(value);

        return this;
    }
    //input date of Birth
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $x("//*[@id='dateOfBirth']/div[1]/div").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    //input subjects
    public RegistrationFormPage setSubject(String value) {
        $x("//*[@id='subjectsInput']").setValue(value);
        $x("//*[@id='subjectsInput']").setValue(value).pressEnter();

        return this;
    }
    //set hobbies
    public RegistrationFormPage setHobbies() {
        $x("//*[@id='hobbies-checkbox-1']").parent().click();
        $x("//*[@id='hobbies-checkbox-3']").parent().click();


        return this;
    }
    //load picture
    public RegistrationFormPage loadPicture() {
        $x("//*[@id='uploadPicture']").uploadFromClasspath("cat1.jpg");

        return this;
    }
    //input current address
    public RegistrationFormPage setCurrAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    //set state
    public RegistrationFormPage setState() {
        $x("//*[@id='state']").click();
        $x("//*[@id='react-select-3-option-2']").click();

        return this;
    }
    //set city
    public RegistrationFormPage setCity() {
        $x("//*[@id='city']").click();
        $x("//*[@id='react-select-4-option-1']").click();

        return this;
    }
    //click submit button
    public RegistrationFormPage clickSubmitButton() {
        buttonClick.click();

        return this;
    }
    //check visible of modal window
    public RegistrationFormPage checkResultTableVisible() {
        resultsTableComponent.checkModal();

        return this;
    }
    //check results
    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}
