import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Gold_2_4195 {
  static HashMap<String, Integer> count;
  static HashMap<String, String> parent;

  static String findParent(String toFind) {
    if (parent.get(toFind).equals(toFind)) {
      return toFind;
    }
    String ancestor = findParent(parent.get(toFind));
    parent.put(toFind, ancestor);
    return ancestor;
  }

  static void setParent(String master, String slave) {
    String masterAncestor = findParent(master);
    String slaveAncestor = findParent(slave);
    if (masterAncestor.equals(slaveAncestor)) {
      return;
    }
    count.put(masterAncestor, count.get(masterAncestor) + count.get(slaveAncestor));
    parent.put(slaveAncestor, masterAncestor);
  }
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i=0;i<T;i++) {
      count = new HashMap<>();
      parent = new HashMap<>();
      int F = Integer.parseInt(br.readLine());
      for (int j=0;j<F;j++) {
        StringTokenizer line = new StringTokenizer(br.readLine());
        String master = line.nextToken();
        String slave = line.nextToken();
        if (!count.containsKey(master)) {
          count.put(master, 1);
          parent.put(master, master);
        }
        if (!count.containsKey(slave)) {
          count.put(slave, 1);
          parent.put(slave, slave);
        }
        setParent(master, slave);
        System.out.println(count.get(findParent(master)));
      }
    }
  }
}
