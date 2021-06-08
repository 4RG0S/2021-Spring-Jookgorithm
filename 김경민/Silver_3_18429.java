import java.util.Scanner;
import java.util.HashSet;
import java.util.Stack;

public class Silver_3_18429 {

  static int result = 0;
  static int weight = 500;
  static int K = 0;

  static void backtrack(int arr[], int N, HashSet<Integer> set, Stack<Integer> stack) {
    if (stack.size() == N) {
      result++;
    } else {
      for (int i=0;i<arr.length;i++) {
        if (set.contains(i))
          continue;
        weight = weight + arr[i] - K;
        if (weight < 500) {
          weight = weight - arr[i] + K;
          continue;
        }
        set.add(i);
        stack.push(i);
        backtrack(arr, N, set, stack);
        stack.pop();
        set.remove(i);
        weight = weight - arr[i] + K;
      }
    }
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    K = scan.nextInt();
    int arr[] = new int[N];

    for (int i=0;i<N;i++) {
      arr[i] = scan.nextInt();
    }
    backtrack(arr, N, new HashSet<>(), new Stack<>());
    System.out.println(result);
  }
}
