package pak;

import less3.TestEmail;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;



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

        throw new RuntimeException("A'm error");
    }

}
