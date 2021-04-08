import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver_3_15655 {

  static void nCr(int n, int r, int arr[], int peekIndex, Stack<Integer> stack) {
    if (stack.size() == r) {
      for (Object num : stack) {
        System.out.print(num + " ");
      }
      System.out.println();
    } else {
      for (int i=peekIndex+1;i<arr.length;i++) {
        stack.add(arr[i]);
        nCr(n, r, arr, i, stack);
        stack.pop();
      }
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    int arr[] = new int[N];
    line = new StringTokenizer(br.readLine());
    for (int i=0;i<N;i++) {
      arr[i] = Integer.parseInt(line.nextToken());
    }
    Arrays.sort(arr);

    nCr(N, M, arr, -1, new Stack<Integer>());
  }
}
