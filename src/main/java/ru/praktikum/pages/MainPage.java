package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Кнопка Войти в аккаунт
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    private By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");

   // Кнопка Личный кабинет
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    // Вкладка Булки
    private final By bunsTab = By.xpath(".//span[text()='Булки']");

    // Вкладка Соусы
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");

    // Вкладка Начинки
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");

    // Активная вкладка
    private final By currentTab = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isMakeOrderButtonDisplayed() {
        try {
            // Ждем до 5 секунд, пока кнопка "Оформить заказ" станет видимой
            return wait.until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton)).isDisplayed();
        } catch (Exception e) {
            // Если кнопка не появилась за 5 секунд, возвращаем false
            return false;
        }
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    public void clickFillingTab() {
        driver.findElement(fillingsTab).click();
    }

    // Проверка активной вкладки

    public boolean isBunsTabActive() {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(currentTab, "Булки"));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSaucesTabActive() {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(currentTab, "Соусы"));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFillingsTabActive() {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(currentTab, "Начинки"));
        } catch (Exception e) {
            return false;
        }
    }
}
