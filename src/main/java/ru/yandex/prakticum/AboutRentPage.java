package ru.yandex.prakticum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRentPage {

    private WebDriver driver;
    //Поле ввода "Когда привезти самокат"
    private By deliveryData = By.xpath(".//div[@class = 'react-datepicker__input-container']/input");
    //Кнопка выбора даты
    private By deliveryDataButton = By.className("react-datepicker__day--019");
    //Выпадающий список "Срок аренды"
    private  By rentTime = By.className("Dropdown-placeholder");
    //Кнопка выбора срока аренды(6 дней)
    private By rentTimeButton = By.xpath(".//div[@class = 'Dropdown-menu']/div[6]");
    //Кнопка "Далее" в правом нижнем углу
    private By continueOrderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[contains(text(), 'Заказать')]");
    //Кнопка "Заказать" в окне подтверждения заказа
    private By confirmOrderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");

    public AboutRentPage(WebDriver driver){
        this.driver = driver;
    }
    //Заполнение поля Когда привести самокат
    public void setDeliveryData(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(deliveryData));
        driver.findElement(deliveryData).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(deliveryDataButton));
        driver.findElement(deliveryDataButton).click();
    }

    //Выбор значения в выпадающем списке Срок аренды
    public void setRentTime(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(rentTime));
        driver.findElement(rentTime).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(rentTimeButton));
        driver.findElement(rentTimeButton).click();
    }

    //Клик на кнопку "Заказать" для продолжения заказа
    public void clickContinueOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(continueOrderButton));
        driver.findElement(continueOrderButton).click();
    }

    //Заполнение всех поле на странице Про аренду
    public  void fillInRentPage(){
        setRentTime();
        setDeliveryData();
        clickContinueOrderButton();
    }

    //Клик на кнопку "Заказать" для подтверждения заказа
    public void clickConfirmOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }

}
