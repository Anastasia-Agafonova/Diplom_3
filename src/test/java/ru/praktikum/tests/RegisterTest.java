package ru.praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.models.User;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.RegisterPage;
import ru.praktikum.utils.UserGenerator;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка успешной регистрации нового пользователя")
    public void registerNewUserTest() {

        User user = UserGenerator.createRandomUser();

        MainPage mainPageLocal = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isUrlCorrect = wait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue("После успешной регистрации не произошел переход на страницу /login", isUrlCorrect);
    }

    @Test
    @DisplayName("Ошибка при коротком пароле")
    @Description("Проверка сообщения 'Некорректный пароль'")
    public void registerWithShortPasswordTest() {
        User user = UserGenerator.createRandomUser();

        MainPage mainPageLocal = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterName(user.getName());
        registerPage.enterEmail(user.getEmail());
        registerPage.enterPassword("12345");
        registerPage.clickRegisterButton();

        Assert.assertEquals(
                "Некорректный пароль",
                registerPage.getPasswordErrorText()
        );
    }
}

