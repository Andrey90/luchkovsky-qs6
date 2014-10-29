package pak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductFilter {

    public static WebDriver driver;

    @DataProvider
    public Object[][] filters() {
        return new Object[][]{
                new Object[]{"http://testng.org/doc/index.html", "TestNG"},
                new Object[]{"http://google.com", "poporo"},
                new Object[]{"http://testng.org", "pamparam"},
        };
    }

    @BeforeSuite
    public void initEnv() {
        driver = new HtmlUnitDriver();

    }

    @Test(dataProvider = "filters")
    public void numberOfFilteredElemantsTest(String siteUrl, String textTofind) {
        driver.get(siteUrl);
        Assert.assertTrue(driver.findElements(By.linkText(textTofind)).size() > 0);

    }

    @AfterSuite
    public void shutEnv() {
        if (driver != null)
            driver.quit();
    }
}