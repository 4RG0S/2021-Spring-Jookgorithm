import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Platinum_5_6549 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      Stack<Integer> s = new Stack<>();
      StringTokenizer line = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(line.nextToken());
      if (N == 0)
        break;
      int a[] = new int[N];

      for(int i=0;i<N;i++) {
        a[i] = Integer.parseInt(line.nextToken());
      }

      long ans = 0;
      for (int i=0; i<N; i++) {
          while(!s.empty() && a[s.peek()] > a[i]) {
              long height = a[s.peek()];
              s.pop();
              long width = i;
              if (!s.empty()) {
                  width = (i - s.peek() - 1);
              }
              if (ans < width*height) {
                  ans = width*height;
              }
          }
          s.push(i);
      }
      while(!s.empty()) {
          long height = a[s.peek()];
          s.pop();
          long width = N;
          if (!s.empty()) {
              width = N-s.peek()-1;
          }
          if (ans < width*height) {
              ans = width*height;
          }
      }
      System.out.println(ans);
    }
  }
}
