package pak;

import org.testng.annotations.*;

/**
 * Created by SuperStar on 28.10.2014.
 */
public class TestStringTest {
    @DataProvider
    public Object[][] filters() {
        return new Object[][]{
                new Object[]{"teststringhome", "tes"}
        };

    @BeforeSuite
    @Test
    @AfterSuite
}
