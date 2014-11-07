package classTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class findeTest {
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
        String prodName = "Nexus";

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));

        driver.findElement(By.className("close")).click();
        driver.findElement(By.className("blue-button")).click();
        driver.findElement(By.id("searchbox")).click();
        driver.findElement(By.id("searchbox")).sendKeys(prodName);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("searchbox"))));
        driver.findElement(By.id("doSearch")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'" + prodName + "')]"))));
        Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(),'" + prodName + "')]")).size() != 0);


    }

    @AfterTest
    public void shutEnv() {
        if (driver != null)
            driver.quit();
        driver.manage().deleteAllCookies();
    }
}

