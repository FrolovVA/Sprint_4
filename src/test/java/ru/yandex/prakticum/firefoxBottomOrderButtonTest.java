package ru.yandex.prakticum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.prakticum.POMfiles.aboutClientPage;
import ru.yandex.prakticum.POMfiles.aboutRentPage;
import ru.yandex.prakticum.POMfiles.mainSamokatPage;

import java.time.Duration;


@RunWith(Parameterized.class)
public class firefoxBottomOrderButtonTest {
    private WebDriver driver;
    private final String clientName;
    private final String clientSecondName;
    private final String clientAdress;
    private final String clientMetro;
    private final String clientPhoneNumber;


    public firefoxBottomOrderButtonTest(String clientName, String clientSecondName, String clientAdress, String clientMetro, String clientPhoneNumber){
        this.clientName = clientName;
        this.clientSecondName = clientSecondName;
        this.clientAdress = clientAdress;
        this.clientMetro = clientMetro;
        this.clientPhoneNumber = clientPhoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getText()    {
        return new Object[][]{
                {"Вовка", "Иванов", "Большой дом", "Сокольники", "88005553535"},
                {"Глеб", "Борисов", "Красный дом", "Курская", "88005545535"}
        };
    }

    @Before
    public void StartUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void FAQTest() throws InterruptedException {
        //Открываем страницу ЯндексСамокат
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //нажатие на верхнюю кнопку Заказать
        mainSamokatPage objeckMainSamokatPage = new mainSamokatPage(driver);
        objeckMainSamokatPage.clickBottomOrderButton();
        //Заполнение данных о клиенте и переход на следующую станицу
        aboutClientPage objeckAboutClientPage = new aboutClientPage(driver);
        objeckAboutClientPage.fillInClientPage(clientName, clientSecondName, clientAdress, clientMetro, clientPhoneNumber);
        //Заполнение данных об аренде и переход к окну подтверждения
        aboutRentPage objectAboutRentPage = new aboutRentPage(driver);
        objectAboutRentPage.fillInRentPage();
        //Подтверждение заказа
        objectAboutRentPage.clickConfirmOrderButton();

        //Получаем элемент надписи на странице подтверждения заказа
        WebElement textOrderConfirmed = driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']"));
        //Проверяем содержит ли надпись текст "Заказ оформлен"
        Assert.assertTrue("True if contains \"Заказ оформлен\"", textOrderConfirmed.getText().contains("Заказ оформлен"));

        //Thread.sleep(2000);
    }


    @After
    public void tearDown() {
        driver.quit();
    }





}
