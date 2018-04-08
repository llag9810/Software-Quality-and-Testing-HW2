import java.io.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if (args.length != 1) {
            throw new RuntimeException("program should take exactly 1 argument.");
        }

        if (args[0].startsWith("-")) {
            args[0] = args[0].substring(1, args[0].length());
        }

        if (!args[0].endsWith(".txt")) {
            throw new RuntimeException("invalid file format, should be txt");
        }

        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        Counter counter = new Counter(bis);
        counter.processCount();

        Output output = new Output(counter.getMap(), counter.getQueue());
        try {
            output.outputInfo(new PrintStream(new FileOutputStream(new File("result.txt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println((end - startTime) / 1e9);
    }
}
