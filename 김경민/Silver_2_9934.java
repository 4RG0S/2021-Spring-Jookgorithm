import java.util.Scanner;
import java.util.StringTokenizer;

public class Silver_2_9934 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int K = Integer.parseInt(scan.nextLine());
    int arr[] = new int[(int)Math.pow(2, K)];
    StringTokenizer line = new StringTokenizer(scan.nextLine());
    for (int i=1;i<arr.length;i++) {
      arr[i] = Integer.parseInt(line.nextToken());
    }

    for (int idx=K;idx>=1;idx--) {
      for (int i=0;i<Math.pow(2, K) / Math.pow(2, idx);i++) {
        int index = (int)Math.pow(2, idx - 1) + (int)Math.pow(2, idx) * i;
        System.out.print(arr[index] + " ");
      }
      System.out.println();
    }

  }
}
