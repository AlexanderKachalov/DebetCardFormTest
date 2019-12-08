import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestClass {
    @Test
    void testFormIfValidateAllInputData() {
        open("http://localhost:9999");
        SelenideElement form;
        form = $(By.className("App_appContainer__3jRx1"));
        form.$("[data-test-id=name] input").setValue("Василий");
        form.$("[data-test-id=phone] input").setValue("+79035783484");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена!" +
                " Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void testFormIfNotValidateName() {
        open("http://localhost:9999");
        SelenideElement form;
        form = $(By.className("App_appContainer__3jRx1"));
        ElementsCollection elements = Selenide.elements(By.className("input__sub"));
        form.$("[data-test-id=name] input").setValue("Vasiliy");
        form.$("[data-test-id=phone] input").setValue("+79035783484");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(elements.get(0)).shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские" +
                " буквы, пробелы и дефисы."));
    }

    @Test
    void testFormIfNotValidatePhone() {
        open("http://localhost:9999");
        SelenideElement form;
        form = $(By.className("App_appContainer__3jRx1"));
        ElementsCollection elements = Selenide.elements(By.className("input__sub"));
        form.$("[data-test-id=name] input").setValue("Василий");
        form.$("[data-test-id=phone] input").setValue("+7(903)578-34-84");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(elements.get(1)).shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например," +
                " +79012345678."));
    }
}
