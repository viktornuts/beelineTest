package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;
import pages.StartPage;
import pages.WorkerSearchPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BeelineTests extends TestBase {

    StartPage startPage = new StartPage();
    WorkerSearchPage workerSearchPage = new WorkerSearchPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Проверка дашборда главной страницы")
    void checkDashboardTest() {
        step("Открываем сайт https://magnitogorsk.beeline.ru/customers/products/", () -> {
            open("https://magnitogorsk.beeline.ru/customers/products/");
        });

        step("check dashboard", () -> {
            $(By.xpath("//span[text()='Прокачать']")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка текста раздела 'Все способы оплаты' для 'Домашний телефон'")
    void checkAllServicesPage() {
        step("Открываем сайт https://magnitogorsk.beeline.ru/customers/products/", () -> {
            open("https://magnitogorsk.beeline.ru/customers/products/");
        });

        step("Переходим в раздел 'Все способы оплаты'", () -> {
            $("[href='/customers/finansy-oplata/popolnenie-scheta/']").click();
        });

        step("Выбираем вкладку 'Домашний телефон'", () -> {
            $(By.xpath("//span[text()='Домашний телефон']")).click();
        });

        step("Проверяем отображение текста раздела 'Все оплаты' для 'Домашний телефон'", () -> {
            $("[class='help-text help-content border_bottom_pay complex-payment-single-windget fast-pay complex-payment_bg']").shouldHave(text("Пополнение счёта с банковской карты"));
            $("[class='help-text complex-payment-single-windget border_bottom_pay fast-pay fast-pay complex-payment_bg']").shouldHave(text("Наличными"));
        });
    }

    @Test
    @DisplayName("PageObj Проверка предупреждений при регистрации работодателя c пустыми данными")
    void registrationAlertPageCheck() {
        open("https://chelyabinsk.hh.ru/");
        startPage.openWorkerSearchPage();
        workerSearchPage.clickPostVacanciesButton();
        registrationPage.clickRegistrationSubmitButton().checkEmailAlert().checkNameAlert().checkPhoneAlert().checkSurnameAlert().checkCompanyNameAlert();
    }

    @Test
    @DisplayName("Проверка раздела 'Карьерная консультация'")
    void checkCareerConsultPage() {
        step("Открываем раздел сайта hh.ru 'Карьерная консультация'", () -> {
           open("https://chelyabinsk.hh.ru/career_consult?hhtmFromLabel=header&hhtmFrom=main");
        });

        step("Проверка отображения текста раздела 'Карьерная консультация'", () -> {
            $("p[class='hero_text']").shouldHave(text("Онлайн-консультация с карьерным экспертом  по вопросам, связанным с развитием карьеры и поиском работы"));
        });
    }

    @Test
    @DisplayName("Проверка стоимости тарифов готовых резюме ")
    void checkExpertResumePage() {
        step("Открываем сайт  hh.ru раздел 'Готовое резюме' ", () -> {
            open("https://chelyabinsk.hh.ru/expert_resume?hhtmFromLabel=header&hhtmFrom=main#price");
        });

        step("Проверяем стоимость тарифа 'Базовый'", () -> {
            $$("div[class='price__info']").get(0).shouldHave(text("Базовый"));
            $$("div[class='price__info']").get(0).shouldHave(text("4 100 руб."));
        });

        step("Проверяем стоимость тарифа 'Оптимальный'", () -> {
            $$("div[class='price__info']").get(1).shouldHave(text("Оптимальный"));
            $$("div[class='price__info']").get(1).shouldHave(text("4 900 руб."));
        });

        step("Проверяем стоимость тарифа 'Максимальный'", () -> {
            $$("div[class='price__info']").get(2).shouldHave(text("Максимальный"));
            $$("div[class='price__info']").get(2).shouldHave(text("7 900 руб."));
        });


    }

}
