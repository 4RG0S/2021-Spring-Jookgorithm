import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Gold_5_7662 {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i=0;i<T;i++) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      int k = Integer.parseInt(br.readLine());

      for (int j=0;j<k;j++) {
        StringTokenizer line = new StringTokenizer(br.readLine());
        String type = line.nextToken();
        int number = Integer.parseInt(line.nextToken());

        if (type.equals("I")) {
            if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
          }
          else {
            map.put(number, 1);
          }
        } else if (type.equals("D")) {
          if (map.size() == 0)
            continue;
          if (number == -1) {
            int firstKey = map.firstKey();
            if (map.get(firstKey) == 1) {
              map.remove(firstKey);
            } else {
              map.put(firstKey, map.get(firstKey) - 1);
            }
          } else if (number == 1) {
            int lastKey = map.lastKey();
            if (map.get(lastKey) == 1) {
              map.remove(lastKey);
            } else {
              map.put(lastKey, map.get(lastKey) - 1);
            }
          }
        }
      }
      if (map.size() == 0) {
        System.out.println("EMPTY");
      } else {
        System.out.println(map.lastKey() + " " + map.firstKey());
      }

    }
  }
}
