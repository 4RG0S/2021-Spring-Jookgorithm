import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Silver_2_15663 {

  static void backtrack(int arr[], int M, Stack<Integer> stack, int peek) {
    if (stack.size() == M) {
      Object array[] = stack.toArray();
      for (Object iter : array) {
        System.out.print(iter + " ");
      }
      System.out.println();
    } else {
      for (int i=peek;i<arr.length;i++) {
        stack.push(arr[i]);
        backtrack(arr, M, stack, i + 1);
        stack.pop();
      }
    }
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int M = scan.nextInt();
    int arr[] = new int[N];

    for(int i=0;i<N;i++) {
      arr[i] = scan.nextInt();
    }
    Arrays.sort(arr);
    backtrack(arr, M, new Stack<>(), 0);
  }
}
