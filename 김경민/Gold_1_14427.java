import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_1_14427 {
  static class SegTree {
    int min[];
    int minIndex[];
    public SegTree(int arr[]) {
      min = new int[arr.length * 4];
      minIndex = new int[arr.length * 4];
      init(0, arr.length - 1, arr, 1);
    }
    void init(int left, int right, int arr[], int index) {
      if (left == right) {
        min[index] = arr[left];
        minIndex[index] = left;
      } else {
        int middle = (left + right) / 2;
        init(left, middle, arr, index * 2);
        init(middle + 1, right, arr, index * 2 + 1);
        minIndex[index] = min[index * 2] <= min[index * 2 + 1]
          ? minIndex[index * 2]
          : minIndex[index * 2 + 1];
        min[index] = min[index * 2] <= min[index * 2 + 1]
          ? min[index * 2]
          : min[index * 2 + 1];
      }
    }
    int query() {
      return minIndex[1] + 1;
    }
    void update(int left, int right, int target, int value, int index) {
      if (target < left || right < target) {
        return;
      }
      if (left == target && target == right) {
        min[index] = value;
        minIndex[index] = target;
      } else {
        int middle = (left + right) / 2;
        update(left, middle, target, value, index * 2);
        update(middle + 1, right, target, value, index * 2 + 1);
        minIndex[index] = min[index * 2] <= min[index * 2 + 1]
          ? minIndex[index * 2]
          : minIndex[index * 2 + 1];
        min[index] = min[index * 2] <= min[index * 2 + 1]
          ? min[index * 2]
          : min[index * 2 + 1];
      }
    }
  }
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N];
    StringTokenizer line = new StringTokenizer(br.readLine());
    for (int i=0;i<N;i++) {
      arr[i] = Integer.parseInt(line.nextToken());
    }
    int M = Integer.parseInt(br.readLine());
    SegTree segTree = new SegTree(arr);
    for (int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(line.nextToken());
      if (type == 1) {
        int target = Integer.parseInt(line.nextToken()) - 1;
        int value = Integer.parseInt(line.nextToken());
        segTree.update(0, N - 1, target, value, 1);
      } else if (type == 2) {
        System.out.println(segTree.query());
      }
    }
  }
}
