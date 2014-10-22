package pak;

import less3.testSum;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

/**
 * Created by bionic on 22.10.14.
 */
public class FirstTest {

    @Test
    public void firstTest() {
        testSum sum = new testSum();
        assertEquals(sum.sum(1, 2),4);
    }
}