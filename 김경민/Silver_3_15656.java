import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver_3_15656 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void printStack(Stack<Integer> stack) throws IOException {
    Object values[] = stack.toArray();
    for (Object value : values) {
      bw.write(value + " ");
    }
    bw.write("\n");
  }

  static void backtrack(int arr[], int M, Stack<Integer> stack) throws IOException {
    if (M == stack.size()) {
      printStack(stack);
    } else {
      for (int i=0;i<arr.length;i++) {
        stack.add(arr[i]);
        backtrack(arr, M, stack);
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
    backtrack(arr, M, new Stack<>());
    bw.flush();
  }
}
