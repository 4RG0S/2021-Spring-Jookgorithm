import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_1_14438 {
  static class segTree {
    int min[];
    public segTree(int arr[]) {
      min = new int[arr.length * 4];
      for (int i=0;i<arr.length;i++) {
        min[i] = Integer.MAX_VALUE;
      }
      init(0, arr.length - 1, arr, 1);
    }
    void init(int left, int right, int arr[], int index) {
      if (left == right) {
        min[index] = arr[left];
        return;
      }
      int middle = (left + right) / 2;
      init(left, middle, arr, index * 2);
      init(middle + 1, right, arr, index * 2 + 1);
      min[index] = Integer.min(min[index * 2], min[index * 2 + 1]);
    }
    void update(int left, int right, int inputIndex, int value, int index) {
      if (right < inputIndex || inputIndex < left) return;
      if (left == inputIndex && inputIndex == right) {
        min[index] = value;
        return;
      }
      if (left == right) return;
      int middle = (left + right) / 2;
      update(left, middle, inputIndex, value, index * 2);
      update(middle + 1, right, inputIndex, value, index * 2 + 1);
      min[index] = Integer.min(min[index * 2], min[index * 2 + 1]);
    }
    int query(int left, int right, int rangeLeft, int rangeRight, int index) {
      if (right < rangeLeft || rangeRight < left) return Integer.MAX_VALUE;
      if (rangeLeft <= left && right <= rangeRight) {
        return min[index];
      }
      int middle = (left + right) / 2;
      int leftVal = query(left, middle, rangeLeft, rangeRight, index * 2);
      int rightVal = query(middle + 1, right, rangeLeft, rangeRight, index * 2 + 1);
      return Integer.min(leftVal, rightVal);
    }
    void print() {
      for(int i=1;i<min.length;i++) {
        System.out.print(min[i] + " ");
      }
      System.out.println();
    }
  }
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N];
    StringTokenizer line = new StringTokenizer(br.readLine());
    for (int i=0;i<N;i++) {
      arr[i] = Integer.parseInt(line.nextToken());
    }
    segTree tree = new segTree(arr);
    int M = Integer.parseInt(br.readLine());
    for (int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(line.nextToken());
      if (type == 1) {
        int index = Integer.parseInt(line.nextToken()) - 1;
        int val = Integer.parseInt(line.nextToken());
        tree.update(0, N-1, index, val, 1);
      } else if (type == 2) {
        int from = Integer.parseInt(line.nextToken()) - 1;
        int to = Integer.parseInt(line.nextToken()) - 1;
        System.out.println(tree.query(0, N-1, from, to, 1));
      }
    }
  }
}
