import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Silver_3_15651 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void duplicateCombination(Stack<Integer> stack, int N, int M) throws IOException {
    if (stack.size() == M) {
      for (int peek : stack) {
        bw.write(peek + " ");
      }
      bw.write("\n");
    } else {
      for (int i=1;i<=N;i++) {
        stack.push(i);
        duplicateCombination(stack, N, M);
        stack.pop();
      }
    }
  }
  public static void main(String args[]) throws IOException {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int M = scan.nextInt();
    duplicateCombination(new Stack<Integer>(), N, M);
    bw.flush();
    bw.close();
    scan.close();
  }
}
