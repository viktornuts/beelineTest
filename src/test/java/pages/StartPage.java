package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class StartPage {

    SelenideElement
            productTvPage = $(By.xpath("//span[text()='Смотрите бесплатно в билайн ТВ']"));

    public StartPage openBeelineTVPage() {
        productTvPage.click();
        return this;
    }

}
