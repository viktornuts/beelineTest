package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EthTvPage {

    public EthTvPage goToForHome500Tariff() {
        open("https://beelineru.ru/tarif-dlya-doma-500-s-tv_ot_bilayn_moskva");
        return this;
    }

}
