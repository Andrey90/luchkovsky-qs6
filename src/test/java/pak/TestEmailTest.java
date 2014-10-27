package pak;

import less3.TestEmail;
import less3.TestSum;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

/**
 * Created with IntelliJ IDEA.
 * User: a.luchkovskiy
 * Date: 27.10.14
 * Time: 12:26
 * To change this template use File | Settings | File Templates.
 */

public class TestEmailTest {

    public static Collection<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"test@test.ua", true}
        });
    }

    private boolean rez;
    private String emailStr;

    public TestEmailTest(String emailStr, boolean rez){
        this.emailStr = emailStr;
        this.rez = rez;
    }

    @Test
    public void TestEmail(){
        TestEmail emTest1 = new TestEmail();
        assertEquals(emTest1.EmTest(emailStr), rez);
    }

}
