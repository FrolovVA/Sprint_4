package ru.yandex.prakticum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class mainSamokatPage {
    private WebDriver driver;
    //Секция со списком вопросов и ответов
    private By sectionFAQ = By.className("Home_FAQ__3uVm4");
    //Кнопки раскрывающие ответы на вопросы
    private  By buttonsFAQ = By.xpath(".//div[@class = 'accordion__item']/div[@class = 'accordion__heading']/div[@class = 'accordion__button']");
    //Абзац с текстом ответа на вопрос
    private  By answerFAQ = By.xpath(".//div[@class = 'accordion__item']/div[@class = 'accordion__panel']/p");
    //Верхняя кнопка "Заказать"
    private By upperOrderButton = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    //Нижняя кнопка "Заказать"
    private  By bottomOrderButton = By.className("Button_Middle__1CSJM");
    //Надпись в окне "Заказ оформлен"
    private  By textOrderConfirmed = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");

    public mainSamokatPage(WebDriver driver) {
        this.driver = driver;
    }
    //Прокручиваем до секции вопросов и ответов
    public void scrollToSectionFAQ() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(sectionFAQ));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(sectionFAQ));
    }
    //Получаем все кнопки раскрытия ответов в лист
    public List<WebElement> getButtonsFAQ() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(buttonsFAQ));
        List<WebElement> buttonsElements = driver.findElements(buttonsFAQ);
        return buttonsElements;
    }
    //Получаем все ответы на вопросы в виде листа
    public List<WebElement> getAnswersFAQ() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(answerFAQ));
        List<WebElement> answersFAQ = driver.findElements(answerFAQ);
        return answersFAQ;
    }
    //Проверяем правильность текста в ответах
    public void checkTextAnswer(int numb, String faqText) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(answerFAQ));
        Assert.assertTrue("Элемент №" + numb + " соответствует", getAnswersFAQ().get(numb).getText().equals(faqText));
    }
    //Клик по верхней кнопке Заказа
    public void clickUpperOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(upperOrderButton));
        driver.findElement(upperOrderButton).click();
    }
    //Клик по нижней кнопке заказа
    public void clickBottomOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(bottomOrderButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottomOrderButton));
        driver.findElement(bottomOrderButton).click();
    }

    //Проверяем содержит ли надпись в окне текст "Заказ оформлен"
    public boolean checkTextOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(textOrderConfirmed));
        //Получаем элемент надписи на странице подтверждения заказа
        WebElement elementTextOrderConfirmed = driver.findElement(textOrderConfirmed);
        //Проверяем содержит ли надпись текст "Заказ оформлен"
        return (elementTextOrderConfirmed.getText().contains("Заказ оформлен"));
    }

}
