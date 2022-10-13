package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.EthTvPage;
import pages.ForHome500TariffPage;
import pages.StartPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BeelineTests extends TestBase {

    StartPage startPage = new StartPage();
    ForHome500TariffPage forHome500TariffPage = new ForHome500TariffPage();
    EthTvPage ethTvPage = new EthTvPage();

    @Test
    @DisplayName("Проверка дашборда главной страницы")
    void checkDashboardTest() {
        step("Открываем сайт https://beelineru.ru/", () -> {
            open("https://beelineru.ru/");
        });

        step("check dashboard", () -> {
            $("[id='b33042']").shouldBe(visible).shouldHave(text("Одна цена всю осень!"));
        });
    }

    @Test
    @DisplayName("Проверка текста раздела 'Акции'")
    void checkAllPromotionsOptions() {
        step("Открываем сайт https://beelineru.ru/", () -> {
            open("https://beelineru.ru/");
        });

        step("Переходим в раздел 'Акции'", () -> {
            $(By.xpath("//a[text()='Акции']")).click();
        });

        step("Проверяем отображение текста раздела 'Акции'", () -> {
            $("[id='b33458']").shouldBe(visible).shouldHave(text("Скидка 50% на 3 месяца новом тарифе «Для тебя и дома 2»"));
            $("[id='b31201']").shouldBe(visible).shouldHave(text("Семейные тарифы. Домашний интернет, ТВ, мобильная связь. Вместе дешевле!"));
        });
    }

    @Test
    @DisplayName("PageObj Проверка отображения страницы тарифа 'Для дома 500 с ТВ'")
    void tariffCheckTest() {
        open("https://beelineru.ru/");
        startPage.openEthTvPage();
        ethTvPage.goToForHome500Tariff();
        forHome500TariffPage.checkTariffInformation();

    }

    @Test
    @DisplayName("Проверка раздела 'О компании'")
    void checkAboutCompanyPage() {

        step("Переходим в раздел 'О компании'", () -> {
            open("https://beelineru.ru/legal/about");
        });

        step("Проверяем информацию в разделе 'О компании'", () -> {
            $("#b1863.bi").shouldHave(text("Более 13 лет билайн приносит в дома цифровое телевидение и интернет"));
        });

    }

    @Test
    @DisplayName("Проверка стоимости 'Лучшие тарифы билайн 2022'")
    void checkTariffsPrices() {
        step("Открываем сайт https://beelineru.ru/", () -> {
            open("https://beelineru.ru/");
        });

        step("Проверяем стоимость тарифа 'Для тебя и дома 2'", () -> {
            $$(".tarifscard-v").get(0).shouldHave(text("Для тебя и дома 2"));
            $$(".tarif-ap-v").get(0).shouldHave(text("650"));
        });

        step("Проверяем стоимость тарифа 'Для тебя и дома 1'", () -> {
            $$(".tarifscard-v").get(1).shouldHave(text("Для тебя и дома 1"));
            $$(".tarif-ap-v").get(1).shouldHave(text("900"));
        });

        step("Проверяем стоимость тарифа 'На максимум+!'", () -> {
            $$(".tarifscard-v").get(2).shouldHave(text("На максимум+!"));
            $$(".tarif-ap-v").get(2).shouldHave(text("2000"));
        });
    }

}
