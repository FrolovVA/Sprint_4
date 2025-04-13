package ru.yandex.prakticum.POMfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class aboutRentPage {

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

    public aboutRentPage(WebDriver driver){
        this.driver = driver;
    }

    //Заполнение поля Когда привести самокат
    public void setDeliveryData(){
        driver.findElement(deliveryData).click();
        driver.findElement(deliveryDataButton).click();
    }
    //Выбор значения в выподающем списке Срок аренды
    public void setRentTime(){
        driver.findElement(rentTime).click();
        driver.findElement(rentTimeButton).click();
    }
    //Клик на кнопку заказать
    public void clickContinueOrderButton(){
        driver.findElement(continueOrderButton).click();
    }


    //Заполенение всех поле на странице Про аренду
    public  void fillInRentPage(){
        setRentTime();
        setDeliveryData();
        clickContinueOrderButton();
    }
    //Кнопка Заказать в окне подтверждения заказа
    private By confirmOrderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");
    //Клик на кнопку Заказать
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }
}
