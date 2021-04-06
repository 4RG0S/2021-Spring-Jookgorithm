import java.util.Scanner;
import java.util.Stack;

public class Gold_5_1405 {

  static boolean visit[][] = new boolean[30][30];
  static int percent[] = new int[4]; //E, W, S, N;
  static int dx[] = {1, -1, 0, 0};
  static int dy[] = {0, 0, 1, -1};
  static double result = 0;

  static void calculate(Stack<Integer> stack) {
    Object values[] = stack.toArray();
    double percentage = 1;
    for (Object value : values) {
      percentage *= (double)percent[(int)value] / 100;
    }
    result += percentage;
  }

  static void backtrack(int index, int n, int x, int y, Stack<Integer> stack) {
    if (index == n) {
      calculate(stack);
    } else {
      for (int i=0;i<4;i++) {
        int tx = x + dx[i];
        int ty = y + dy[i];
        if (visit[ty][tx])
          continue;
        visit[ty][tx] = true;
        stack.push(i);
        backtrack(index + 1, n, tx, ty, stack);
        stack.pop();
        visit[ty][tx] = false;
      }
    }
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    percent[0] = scan.nextInt();
    percent[1] = scan.nextInt();
    percent[2] = scan.nextInt();
    percent[3] = scan.nextInt();
    visit[15][15] = true;
    backtrack(0, n, 15, 15, new Stack<Integer>());
    System.out.println(result);
    scan.close();
  }
}
