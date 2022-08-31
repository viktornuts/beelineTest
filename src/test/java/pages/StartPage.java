package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class StartPage {

    SelenideElement
            workerSearchPage = $(By.xpath("//span[text()='Я ищу сотрудника']"));

    public StartPage openWorkerSearchPage() {
        workerSearchPage.click();
        return this;
    }

}
