package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class ProductTVPage {

    SelenideElement
            becomeASubscriberButton = $(By.xpath("//div[text()='Стать абонентом билайн тв']"));


    public ProductTVPage clickPostVacanciesButton() {
        becomeASubscriberButton.scrollIntoView(true);
        becomeASubscriberButton.click();
        return this;
    }

}