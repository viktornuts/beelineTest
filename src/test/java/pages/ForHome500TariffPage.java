package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class ForHome500TariffPage {

    SelenideElement
            informationTariff = $("#b30353.bi");


    public ForHome500TariffPage checkTariffInformation() {
        informationTariff.shouldBe(Condition.visible);
        return this;
    }

}