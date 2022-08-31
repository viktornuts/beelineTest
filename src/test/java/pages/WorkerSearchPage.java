package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class WorkerSearchPage {

    SelenideElement
            postVacanciesButton = $(".action--x1p9SZ3icsnKRxJcF5kI");


    public WorkerSearchPage clickPostVacanciesButton() {
        postVacanciesButton.scrollIntoView(true);
        postVacanciesButton.click();
        return this;
    }

}