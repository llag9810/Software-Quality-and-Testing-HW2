import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Output {
    private HashMap<String, Integer> map;
    private PriorityQueue<String> queue;

    public Output(HashMap<String, Integer> map, PriorityQueue<String> queue) {
        this.map = map;
        this.queue = queue;
    }

    public void outputInfo(PrintStream ps) {
        while (!queue.isEmpty()) {
            String s = queue.poll();
            ps.println(s + " " + map.get(s));
        }
    }
}
