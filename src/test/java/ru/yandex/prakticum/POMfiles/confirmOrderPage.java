package ru.yandex.prakticum.POMfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class confirmOrderPage {
    private WebDriver driver;

    //Кнопка Заказать в окне подтверждения заказа
    private By confirmOrderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");

    public confirmOrderPage(WebDriver driver){
        this.driver = driver;
    }

    //Клик на кнопку Заказать
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }
}
