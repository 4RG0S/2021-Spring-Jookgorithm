import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_4_3273 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    StringTokenizer line = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(br.readLine());
    int result = 0;
    boolean arr[] = new boolean[1000001];
    while(line.hasMoreTokens()) {
      arr[Integer.parseInt(line.nextToken())] = true;
    }

    for(int i=1;i<=x/2 + 1;i++) {
      if (arr[i] && arr[x - i])
        result++;
    }
    System.out.println(result);
  }
}
