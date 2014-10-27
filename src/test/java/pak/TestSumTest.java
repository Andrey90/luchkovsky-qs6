package pak;

import less3.TestSum;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;



public class TestSumTest {



    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0}, {1, 1, 2}, {2,2,5}
        });
    }


    private int sumArg1;
    private int sumArg2;
    private int sumRes;



    public TestSumTest(int sumArg1, int sumArg2, int sumRes) {
        this.sumArg1 = sumArg1;
        this.sumArg2 = sumArg2;
        this.sumRes = sumRes;
    }

    @Test
    public void TestEmailTest() {
        TestSum sum = new TestSum();
        assertEquals(sum.sum(sumArg1, sumArg2), sumRes);

    }

}