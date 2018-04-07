import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        /*if (args.length != 1) {
            System.out.println("usage: wc.exe [filename]");
            System.exit(0);
        }

        if (!args[0].endsWith(".txt")) {
            System.out.println("invalid file format, should be txt");
            System.exit(0);
        }

        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }*/
        Counter counter = new Counter(System.in);
        counter.processCount();

        Output output = new Output(counter.getMap(), counter.getQueue());
        output.outputInfo(System.out);
    }
}
