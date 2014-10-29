package BuyTest;

import actors.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;

/**
 * Created by SuperStar on 29.10.2014.
 */
public class BuyProductTest {

    @Test
    public void buySingleProduct(HashMap<String, Double> product, User user) {
        HomePage homePage = new HomePage();
        homePage.addToBascket(product);
        homePage.openBasckets();
        BasketPage basketPage = new BasketPage();
        basketPage.buy();
        if (!basketPage.isBuySuccess()) {
            LoginPage loginPage = new LoginPage();
            loginPage.login(user);

        }
        Assert.assertTrue(basketPage.isBuySuccess());
    }
}
