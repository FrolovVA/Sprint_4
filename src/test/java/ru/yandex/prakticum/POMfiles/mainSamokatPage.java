package ru.yandex.prakticum.POMfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class mainSamokatPage {

    private WebDriver driver;
    //Секция со списком вопросов и ответов
    private By sectionFAQ = By.className("Home_FAQ__3uVm4");
    //Кнопки раскрывающие ответы на вопросы
    private  By buttonsFAQ = By.xpath(".//div[@class = 'accordion__item']/div[@class = 'accordion__heading']/div[@class = 'accordion__button']");
    //Обзац с текстом ответа на вопрос
    private  By answerFAQ = By.xpath(".//div[@class = 'accordion__item']/div[@class = 'accordion__panel']/p");
    //Верхняя кнопка "Заказать"
    private By upperOrderButton = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    //Нижняя кнопка "Заказать"
    private  By bottomOrderButton = By.className("Button_Middle__1CSJM");


    public mainSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    //Прокручиваем до секции вопросов и ответов
    public void scrollToSectionFAQ() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(sectionFAQ));
    }
    //Получаем все кнопки раскрытия ответов в лист
    public List<WebElement> getButtonsFAQ() {
        List<WebElement> buttonsElements = driver.findElements(buttonsFAQ);
        return buttonsElements;
    }
    //Получаем все ответы на вопросы в виде листа
    public List<WebElement> getAnswersFAQ() {
        List<WebElement> answersFAQ = driver.findElements(answerFAQ);
        return answersFAQ;
    }




    //Клик по верхней кнопке Заказа
    public void clickUpperOrderButton(){
        driver.findElement(upperOrderButton).click();
    }

    //Клик по нижней кнопке заказа
    public void clickBottomOrderButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottomOrderButton));
        driver.findElement(bottomOrderButton).click();
    }




}
