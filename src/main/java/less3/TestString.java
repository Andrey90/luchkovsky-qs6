package less3;

//import java.io.BufferedWriter;
import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.PrintWriter;


public class TestString {


    public void isContainsStr(String str1, String str2) throws FileNotFoundException {
        PrintWriter myfile = new PrintWriter("myresult.txt");

        if (str1.contains(str2)) {
            myfile.println(true);
        }
        else
            myfile.println(false);

        myfile.close();
    }

}
