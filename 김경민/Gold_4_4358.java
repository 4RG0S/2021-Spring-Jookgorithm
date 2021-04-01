import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Gold_4_4358 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap<>();
    int sum = 0;
    String input = "";
    while((input = br.readLine()) != null) {
      if (map.containsKey(input)) {
        map.put(input, map.get(input) + 1);
      } else {
        map.put(input, 1);
      }
      sum++;
    }
    Object keys[] = map.keySet().toArray();
    Arrays.sort(keys);
    for (Object key : keys) {
      System.out.printf("%s %.4f\n", key, ((double)map.get(key) / sum * 100));
      // System.out.println(map.get(key));
    }
    // System.out.println(sum);
  }
}
