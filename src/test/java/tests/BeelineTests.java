package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.BeelineTvPage;
import pages.StartPage;
import pages.ProductTVPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BeelineTests extends TestBase {

    StartPage startPage = new StartPage();
    ProductTVPage productTVPage = new ProductTVPage();
    BeelineTvPage beelineTvPage = new BeelineTvPage();

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
    void checkAllPaymentOptions() {
        step("Открываем сайт https://magnitogorsk.beeline.ru/customers/products/", () -> {
            open("https://magnitogorsk.beeline.ru/customers/products/");
        });

        step("Переходим в раздел 'Все способы оплаты'", () -> {
            $(By.xpath("//span[text()='все способы оплаты']")).click();
        });

        step("Выбираем вкладку 'Домашний телефон'", () -> {
            switchTo().window(1);
            sleep(10000);
            $(By.xpath("//a[text()='Домашний телефон']")).shouldBe(visible, Duration.ofSeconds(30)).click();
        });

        step("Проверяем отображение текста раздела 'Все оплаты' для 'Домашний телефон'", () -> {
            $("[class='help-text help-content border_bottom_pay complex-payment-single-windget fast-pay complex-payment_bg']").shouldHave(text("Пополнение счёта с банковской карты"));
            $("[class='help-text complex-payment-single-windget border_bottom_pay fast-pay fast-pay complex-payment_bg']").shouldHave(text("Наличными"));
        });
    }

    @Test
    @DisplayName("PageObj Проверка отображения страницы 'Стать абонентом билайн тв'")
    void registrationPageCheck() {
        open("https://magnitogorsk.beeline.ru/customers/products/");
        startPage.openBeelineTVPage();
        productTVPage.clickPostVacanciesButton();
        beelineTvPage.checkPageInformation();
    }

    @Test
    @DisplayName("Проверка стоимости золотого номера")
    void checkGoldenNumberPrice() {
        step("Открываем сайт https://magnitogorsk.beeline.ru/customers/products/", () -> {
            open("https://magnitogorsk.beeline.ru/customers/products/");
        });

        step("В блоке 'Красивые номера' выбираем 'Золотые'", () -> {
            $(By.xpath("//span[text()='Золотые']")).click();
        });

        step("Проверяем стоимость золотого номера", () -> {
            $("[class='MgQFWr tNxpRB nviGIG QkPQZ7']").shouldHave(text("15 000 ₽"));
        });
    }

    @Test
    @DisplayName("Проверка стоимости тарифов")
    void checkTariffsPrices() {
        step("Открываем сайт  Билайн раздел 'Тарифы' ", () -> {
            open("https://magnitogorsk.beeline.ru/customers/products/mobile/tariffs/");
        });

        step("Проверяем стоимость тарифа 'Базя'", () -> {
            $$("div[class='jRBMEz']").get(0).shouldHave(text("Базя"));
            $$("span[class='p8xSsR PnnGR4 WnyeUH']").get(0).shouldHave(text("610"));
        });

        step("Проверяем стоимость тарифа 'Юнг'", () -> {
            $$("div[class='jRBMEz']").get(1).shouldHave(text("Юнг"));
            $$("span[class='p8xSsR PnnGR4 WnyeUH']").get(1).shouldHave(text("510"));
        });

        step("Проверяем стоимость тарифа 'Пуш'", () -> {
            $$("div[class='jRBMEz']").get(2).shouldHave(text("Пуш"));
            $$("span[class='p8xSsR PnnGR4 WnyeUH']").get(2).shouldHave(text("690"));
        });

        step("Проверяем стоимость тарифа 'Тапа'", () -> {
            $$("div[class='jRBMEz']").get(3).shouldHave(text("Тапа"));
            $$("span[class='p8xSsR PnnGR4 WnyeUH']").get(3).shouldHave(text("360"));
        });

        step("Проверяем стоимость тарифа 'Пинг'", () -> {
            $$("div[class='jRBMEz']").get(4).shouldHave(text("Пинг"));
            $$("span[class='p8xSsR PnnGR4 WnyeUH']").get(4).shouldHave(text("440"));
        });
    }

}
