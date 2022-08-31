package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BeelineTvPage {
    SelenideElement

            pageInformation = $(By.xpath("//h1[@class='_2tpAe']"));

    public BeelineTvPage checkPageInformation () {
        pageInformation.shouldBe(Condition.visible).shouldHave(Condition.text("Страница не найдена"));
        return this;
    }

}
