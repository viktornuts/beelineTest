package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class StartPage {

    SelenideElement
            etherTvPage = $("#b417.bi");

    public StartPage openEthTvPage() {
        etherTvPage.click();
        return this;
    }

}
