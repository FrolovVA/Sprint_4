package ru.yandex.prakticum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class UpperOrderButtonTest {
    private WebDriver driver;
    private final String clientName;
    private final String clientSecondName;
    private final String clientAdress;
    private final String clientMetro;
    private final String clientPhoneNumber;
    private final DriverFactory driverFactory= new DriverFactory();

    public UpperOrderButtonTest(String clientName, String clientSecondName, String clientAdress, String clientMetro, String clientPhoneNumber){
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
        driverFactory.initDriver();
        driver = driverFactory.getDriver();
    }

    @Test
    public void FAQTest() throws InterruptedException {
        //Открываем страницу ЯндексСамокат
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //нажатие на верхнюю кнопку Заказать
        mainSamokatPage objeckMainSamokatPage = new mainSamokatPage(driver);
        objeckMainSamokatPage.clickUpperOrderButton();
        //Заполнение данных о клиенте и переход на следующую станицу
        aboutClientPage objeckAboutClientPage = new aboutClientPage(driver);
        objeckAboutClientPage.fillInClientPage(clientName, clientSecondName, clientAdress, clientMetro, clientPhoneNumber);
        //Заполнение данных об аренде и переход к окну подтверждения
        aboutRentPage objectAboutRentPage = new aboutRentPage(driver);
        objectAboutRentPage.fillInRentPage();
        //Подтверждение заказа
        objectAboutRentPage.clickConfirmOrderButton();
        //Проверяем, появилась ли надпись, подтверждающая, что заказ оформлен
        Assert.assertTrue("True if contains Заказ оформлен", objeckMainSamokatPage.checkTextOrder());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
