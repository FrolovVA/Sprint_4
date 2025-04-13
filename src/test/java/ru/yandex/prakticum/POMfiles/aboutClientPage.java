package ru.yandex.prakticum.POMfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class aboutClientPage {

    private WebDriver driver;

    //Поле ввода "Имя"
    private By clientName = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Имя']");
    //Поле ввода "Фамилия"
    private By clientSecondName = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Фамилия']");
    //Поле ввода "Адрес"
    private  By clientAdress = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле ввода "Ближайшая станция метро"
    private By clientMetro = By.className("select-search__input");
    //Поле ввода "Номер телефона"
    private  By clientPhoneNumber = By.xpath(".//div[@class = 'Order_Form__17u6u']/div[@class = 'Input_InputContainer__3NykH']/input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" в правом нижнем углу
    private By continueOrderButton = By.className("Button_Middle__1CSJM");

    public aboutClientPage(WebDriver driver){
        this.driver = driver;
    }
    //Заполнения поля Имя
    public void setClientName(String name){
        driver.findElement(clientName).sendKeys(name);
    }
    //Заполнение поня Фамилия
    public void setClientSecondName(String secondName){
        driver.findElement(clientSecondName).sendKeys(secondName);
    }
    //Заполнение поля Адрес
    public void setClientAdress(String adress){
        driver.findElement(clientAdress).sendKeys(adress);
    }
    //Заполнение поля Метро
    public void setClientMetro(String metro) throws InterruptedException {
        //new Select(driver.findElement(clientMetro)).selectByVisibleText(metro);
        driver.findElement(clientMetro).sendKeys(metro);
        //Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.className("select-search__select"));
        items.get(0).click();
    }
    //Заполнение поля номер телефона
    public void setClientPhoneNumber(String phoneNumber){
        driver.findElement(clientPhoneNumber).sendKeys(phoneNumber);
    }
    //Клик по кнопке Далее
    public void clickContinueOrderButton(){
        driver.findElement(continueOrderButton).click();
    }

    //Заполнение всех поле на странице Для кого самокат
    public void fillInClientPage(String name, String secondName, String adress, String metro, String phoneNumber) throws InterruptedException {
        setClientName(name);
        setClientSecondName(secondName);
        setClientAdress(adress);
        setClientPhoneNumber(phoneNumber);
        setClientMetro(metro);
        clickContinueOrderButton();

    }

}
