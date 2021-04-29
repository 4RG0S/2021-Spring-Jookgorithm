import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Silver_3_10974 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static void printStack(Stack<Integer> stack) throws IOException {
    Object values[] = stack.toArray();
    for (Object value : values) {
      bw.write(value + " ");
    }
    bw.write("\n");
  }
  static void backtrack(int N, HashSet<Integer> set, Stack<Integer> stack) throws IOException {
    if (set.size() == N) {
      printStack(stack);
    } else {
      for (int i=1;i<=N;i++) {
        if (!set.contains(i)) {
          set.add(i);
          stack.push(i);
          backtrack(N, set, stack);
          stack.pop();
          set.remove(i);
        }
      }
    }
  }
  public static void main(String args[]) throws IOException {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    backtrack(N, new HashSet<Integer>(), new Stack<Integer>());
    bw.flush();
  }
}
