package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    SelenideElement
            registrationSubmitButton = $(By.xpath("//button[@data-qa='employer-registration-submit']")),
            surnameAlert = $(By.xpath("//div[text()='Укажите вашу фамилию']")),
            nameAlert = $(By.xpath("//div[text()='Укажите ваше имя']")),
            emailAlert = $(By.xpath("//div[text()='Укажите электронную почту']")),
            companyNameAlert = $(By.xpath("//div[text()='Укажите название компании']")),
            phoneAlert = $(By.xpath("//div[text()='Укажите номер телефона']"));


    public RegistrationPage clickRegistrationSubmitButton() {
        registrationSubmitButton.scrollIntoView(true);
        registrationSubmitButton.click();
        return this;
    }

    public RegistrationPage checkSurnameAlert() {
        surnameAlert.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage checkNameAlert() {
        nameAlert.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage checkEmailAlert() {
        emailAlert.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage checkPhoneAlert() {
        phoneAlert.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage checkCompanyNameAlert() {
        companyNameAlert.shouldBe(Condition.visible);
        return this;
    }
}
