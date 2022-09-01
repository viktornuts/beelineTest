package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EthTvPage {
    SelenideElement

            forHome500Tariff = $("[href='/tarif-dlya-doma-500-s-tv_ot_bilayn_moskva']");

    public EthTvPage goToForHome500Tariff() {
        forHome500Tariff.click();
        return this;
    }

}
