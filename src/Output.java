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
        String[] s = new String[queue.size()];
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            s[i] = queue.poll();
        }

        for (int i = s.length - 1; i >= 0; i--) {
            ps.println(s[i] + " " + map.get(s[i]));
        }
    }
}
