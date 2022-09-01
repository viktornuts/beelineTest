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
        step("Открываем сайт https://beelineru.ru/", () -> {
            open("https://beelineru.ru/");
        });

        step("check dashboard", () -> {
            $("[id='b32898']").shouldBe(visible).shouldHave(text("Одна цена всё лето!"));
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
            $("[id='b32898']").shouldBe(visible).shouldHave(text("«50 Гб в подарок»"));
            $("[id='b33457']").shouldBe(visible).shouldHave(text("Скидка 50%"));
            $("[id='b31200']").shouldBe(visible).shouldHave(text("«Для тебя и дома»"));
            $("[id='b20928']").shouldBe(visible).shouldHave(text("«Близкие люди»"));
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
    @DisplayName("Отрпаввление данных на проверку подключения дома к билайн")
    void checkGoldenNumberPrice() {
        step("Открываем сайт https://beelineru.ru/", () -> {
            open("https://beelineru.ru/");
        });

        step("Вносим данные по наименованию города", () -> {
            $("#b33035.bi.formCity").setValue("Магнитогорск");
        });

        step("Вносим данные по наименованию улицы", () -> {
            $("#b33036.bi.formStreet").setValue("Гагарина");
        });

        step("Вносим данные по номеру дома", () -> {
            $("#b33037.bi.formHouse").setValue("21");
        });

        step("Вносим данные по номеру телефона", () -> {
            $("#b33037.bi.formHouse").setValue("9090995477");
        });

        step("Проверяем ответ от билайна", () -> {
            $("#b1433.bi.ansTel").shouldBe(visible).shouldHave(text("Ваш запрос на проверку технической возможности успешно отправлен!"));
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
