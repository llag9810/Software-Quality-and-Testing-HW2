/*
package unittest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainTest {

    @Test(expected = RuntimeException.class)
    public void mainTest1() {
        Main.main(null);
    }

    @Test(expected = RuntimeException.class)
    public void mainTest2() {
        String[] args = {"a.jpg"};
        Main.main(args);
    }

    @Test(expected = NullPointerException.class)
    public void mainTest3() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setErr(new PrintStream(os));
        String[] args = {"b.txt"};
        Main.main(args);
        assertThat(os.toString(), is("File not found"));
        System.setErr(System.err);
    }

    @Test
    public void mainTest4() {
        String[] args = {"testcase/testm10.txt"};
        Main.main(args);
    }
}
*/
