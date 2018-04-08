import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
    private HashMap<String, Integer> map;
    private PriorityQueue<String> queue;
    private InputStream is;
    private Scanner scanner;

    public Counter(InputStream is) {
        map = new HashMap<>();
        queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c1 = map.getOrDefault(o1, 0);
                int c2 = map.getOrDefault(o2, 0);
                if (c1 - c2 != 0) {
                    return c1 - c2;
                }

                return o1.compareTo(o2);
            }
        });
        this.is = is;
        scanner = new Scanner(is);
    }

    public void processCount() {
        Pattern pattern = Pattern.compile("[A-Za-z]+(-[A-Za-z]*)?");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String s = matcher.group().toLowerCase();
                if (s.endsWith("-")) {
                    s = s.substring(0, s.length()  - 1);
                }
                int count = map.getOrDefault(s, 0) + 1;
                map.put(s, count);
                if (queue.isEmpty()) {
                    queue.add(s);
                } else {
                    if (map.getOrDefault(s, 0) >= map.get(queue.peek())) {
                        if (queue.contains(s)) {
                            queue.remove(s);
                        }
                        queue.add(s);
                    }

                    if (queue.size() >= 100) {
                        queue.poll();
                    }
                }
            }
        }
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }

    public PriorityQueue<String> getQueue() {
        return queue;
    }
}
