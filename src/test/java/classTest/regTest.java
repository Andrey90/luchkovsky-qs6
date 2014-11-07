package classTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class regTest {

    public static WebDriver driver;

    @DataProvider
    public Object[][] url() {
        return new Object[][]{
                new Object[]{"http://hotline.ua"},
        };
    }

    @BeforeTest
    public void initEnv() {
        driver = new FirefoxDriver();

    }

    @Test(dataProvider = "url")
    public void pos(String siteUrl) {
        driver.get(siteUrl);
        String email = "emaqrte3@mail.ru";
        String pass = "password";
        String nik = "nik";

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));

        driver.findElement(By.className("close")).click();
        driver.findElement(By.className("blue-button")).click();
        driver.findElement(By.className("reg")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("nick")).sendKeys(nik);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("password2")).sendKeys(pass);
        driver.findElement(By.className("blue-button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("first_name"))));
        Assert.assertTrue(driver.findElement(By.name("first_name")).isDisplayed(), "Register ok ");


    }


    @Test(dataProvider = "url")
    public void neg(String siteUrl) {
        driver.get(siteUrl);
        String email = "emai1@mail.ru";
        String pass = "password";
        String nik = "nik";

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));

        driver.findElement(By.className("close")).click();
        driver.findElement(By.className("blue-button")).click();
        driver.findElement(By.className("reg")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("nick")).sendKeys(nik);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("password2")).sendKeys(pass);
        driver.findElement(By.className("blue-button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("errors"))));
        Assert.assertTrue(driver.findElement(By.className("errors")).isDisplayed(), "Register failed");


    }

    @AfterTest
    public void shutEnv() {
        if (driver != null)
            driver.quit();
    }
}