package ru.yandex.prakticum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AboutClientPage {

    private WebDriver driver;
    //Поле ввода "Имя"
    private By clientName = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Имя']");
    //Поле ввода "Фамилия"
    private By clientSecondName = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Фамилия']");
    //Поле ввода "Адрес"
    private  By clientAddress = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле ввода "Ближайшая станция метро"
    private By clientMetro = By.className("select-search__input");
    //Поле ввода "Номер телефона"
    private  By clientPhoneNumber = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" в правом нижнем углу
    private By continueOrderButton = By.className("Button_Middle__1CSJM");
    //Список подсказок для поля метро
    private By listMetro= By.className("select-search__select");

    public AboutClientPage(WebDriver driver){
        this.driver = driver;
    }
    //Заполнения поля Имя
    public void setClientName(String name){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(clientName));
        driver.findElement(clientName).sendKeys(name);
    }
    //Заполнение поля Фамилия
    public void setClientSecondName(String secondName){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(clientSecondName));
        driver.findElement(clientSecondName).sendKeys(secondName);
    }
    //Заполнение поля Адрес
    public void setClientAdress(String adress){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(clientAddress));
        driver.findElement(clientAddress).sendKeys(adress);
    }
    //Заполнение поля Метро
    public void setClientMetro(String metro) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(clientMetro));
        driver.findElement(clientMetro).sendKeys(metro);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(listMetro));
        List<WebElement> items = driver.findElements(listMetro);
        items.get(0).click();
    }
    //Заполнение поля номер телефона
    public void setClientPhoneNumber(String phoneNumber){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(clientPhoneNumber));
        driver.findElement(clientPhoneNumber).sendKeys(phoneNumber);
    }
    //Клик по кнопке Далее
    public void clickContinueOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(continueOrderButton));
        driver.findElement(continueOrderButton).click();
    }

    //Заполнение всех поле на странице Для кого самокат
    public void fillInClientPage(String name, String secondName, String address, String metro, String phoneNumber) throws InterruptedException {
        setClientName(name);
        setClientSecondName(secondName);
        setClientAdress(address);
        setClientPhoneNumber(phoneNumber);
        setClientMetro(metro);
        clickContinueOrderButton();
    }

}
