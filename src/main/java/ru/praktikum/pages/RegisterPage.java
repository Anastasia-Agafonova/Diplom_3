package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;

    // Поля Имя
    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");

    // Поле Email
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");

    // Поле Пароль
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");

    // Кнопка Зарегистрироваться
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // Ссылка Войти
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    // Ошибка Некорректный пароль
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }
}
