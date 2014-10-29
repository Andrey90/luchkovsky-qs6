package pak;

import less3.TestString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.io.*;

public class TestStringTest {
    public static WebDriver driver;
    public TestString testString;


    @DataProvider
    public Object[][] filters() {
        return new Object[][]{
                new Object[]{"teststringhome", "test"}

        };

    }

    @BeforeTest
    public void test(){
        driver = new HtmlUnitDriver();
        testString = new TestString();
    }

    @Test(dataProvider = "filters")
    public void testData(String str1, String str2) throws IOException {
        testString.isContainsStr(str1, str2);

        String line = null;
        BufferedReader reader = new BufferedReader( new FileReader ("myresult.txt"));
        StringBuilder  stringBuilder = new StringBuilder();

        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );

        }
        String strFromFile = stringBuilder.toString();
        reader.close();

        Assert.assertTrue(new Boolean(strFromFile));
    }

    @AfterTest
    public void deleteFile(){
        File file = new File("myresult.txt");

        if(file.delete()){
            System.out.println(file.getName() + " is deleted!");
        }else{
            System.out.println("Delete operation is failed.");
        }
    }



}
