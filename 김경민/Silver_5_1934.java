import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_5_1934 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i=0;i<T;i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(line.nextToken());
      int B = Integer.parseInt(line.nextToken());
      for (int j=1;j<=B;j++) {
        if ((A * j) % B == 0) {
          System.out.println(A * j);
          break;
        }
      }
    }
  }
}
