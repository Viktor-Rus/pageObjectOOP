package com.demoqa.pages;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.elements.Button;
import com.demoqa.elements.Input;
import com.demoqa.elements.RadioButton;
import com.demoqa.pages.components.*;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultTableComponent = new ResultsTableComponent();
    private SubjectsComponent subjectsComponent = new SubjectsComponent();
    private HobbiesComponent hobbiesComponent = new HobbiesComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();

    private SelenideElement uploadPicture = $("#uploadPicture");

    Input lastNameInput = new Input("lastNameInput",$("#lastName"));
    Input emailInput =  new Input("emailInput",$("#userEmail"));
    Input currentAddressInput =  new Input("currentAddressInput", $("#currentAddress"));
    Input firstNameInput = new Input ("firstNameInput", $("#firstName"));
    Button submit = new Button("Submit", $(byText("Submit")));
    RadioButton gender = new RadioButton("gender",  $("#genterWrapper"));

    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage pressSubmit() {
        submit.click();

        return this;
    }
    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        gender.setElement(value);
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationFormPage setUserSubjects(String value1, String value2, String value3) {
        subjectsComponent.setSubjects(value1, value2, value3);
        return this;
    }

    public RegistrationFormPage setHobbies(String value1, String value2) {
        hobbiesComponent.setHobbies(value1, value2);

        return this;
    }
    public RegistrationFormPage setStateAndCity(String value1, String value2) {
        stateAndCityComponent.setStateAndCity(value1, value2);

        return this;
    }

    public RegistrationFormPage setUploadFile(String value) {
        uploadPicture.uploadFile(new File("src/test/resources/test_file.png"));

        return this;
    }

        public RegistrationFormPage checkResultsTableVisible () {
            resultTableComponent.checkVisible();

            return this;
    }

    public RegistrationFormPage checkResult (String key, String value){
            resultTableComponent.checkResult(key, value);

        return this;
    }


    }
