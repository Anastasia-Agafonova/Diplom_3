package ru.praktikum.pages;

import io.opentelemetry.internal.shaded.jctools.queues.MpscArrayQueue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // Поле email
    private final By emailInput = By.xpath(".//input[@name='name']");

    // Поле пароль
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");

    // Кнопка Войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    // Кнопка Зарегистрироваться
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");

    // Ссылка на восстановление пароля
    private final By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String email, String password) {
    setEmail(email);
    setPassword(password);
    clickLoginButton();
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void clickForgotPasswordLink() {
        driver.findElement((forgotPasswordLink)).click();
    }
}
