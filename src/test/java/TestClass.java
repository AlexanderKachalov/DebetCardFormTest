
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestClass {
    SelenideElement form;

    @Test
    void testFormIfValidateAllInputData() {
        inputData("Василий", "+79035783484");
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена!" +
                " Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void testFormIfNotValidateName() {
        inputData("Vasiliy", "+79035783484");
        form.$$(".input__sub").first().shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские" +
                " буквы, пробелы и дефисы."));
    }

    @Test
    void testFormIfNotValidatePhone() {
        inputData("Василий", "+7(903)578-34-84");
        form.$$(".input__sub").last().shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например," +
                " +79012345678."));
    }

    private void inputData (String text, String tel) {
        open("http://localhost:9999");
        form = $(By.className("App_appContainer__3jRx1"));
        form.$("[data-test-id=name] input").setValue(text);
        form.$("[data-test-id=phone] input").setValue(tel);
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
    }
}
