package ru.yandex.prakticum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.prakticum.POMfiles.mainSamokatPage;

import java.time.Duration;


@RunWith(Parameterized.class)
public class chromeFAQTest {
    private WebDriver driver;
    private final int numb;
    private final String faqText;


    public chromeFAQTest(int numb, String faqText){
        this.numb = numb;
        this.faqText = faqText;
    }

    @Parameterized.Parameters
    public static Object[][] getText()    {
        return new Object[][]{
        {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
        {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
        {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
        {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
        {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
        {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
        {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
        {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void FAQTest() throws InterruptedException {
        //Открываем страницу ЯндексСамокат
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //Создаем объект класса maniSamokatPage
        mainSamokatPage objectMainSamokatPage = new mainSamokatPage(driver);
        //Прокручиваем страницу до секции с вопросами
        objectMainSamokatPage.scrollToSectionFAQ();
        //Получаем все кнопки в виде листа и нажимаем на кнопку по порядку
        objectMainSamokatPage.getButtonsFAQ().get(numb).click();
        //Проверка соответствия текста
        Assert.assertTrue("Элемент №" + numb + " соответствует", objectMainSamokatPage.getAnswersFAQ().get(numb).getText().equals(faqText));
        //System.out.println(elements.get(numb).getText());
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
