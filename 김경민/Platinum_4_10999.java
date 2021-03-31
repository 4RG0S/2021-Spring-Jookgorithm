import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Platinum_4_10999 {

  static class SegtreeWithLazy {
    static class Tree {
      long value, lazy;
      public Tree(long value, long lazy) {
        this.value = value;
        this.lazy = lazy;
      }
    }
    static Tree arr[];
    public SegtreeWithLazy(long num[]) {
      arr = new Tree[num.length * 4];
      init(0, num.length - 1, 1, num);
    }
    void init(int left, int right, int index, long[] num) {
      if (left == right) {
        arr[index] = new Tree(num[left], 0);
      } else {
        int middle = (left + right) / 2;
        init(left, middle, index * 2, num);
        init(middle + 1, right, index * 2 + 1, num);
        arr[index] = new Tree(arr[index * 2].value + arr[index * 2 + 1].value, 0);
      }
    }
    void addLazy(int left, int right, long rangeLeft, long rangeRight, long val, int index) {
      if (arr[index].lazy != 0) {
        arr[index].value += arr[index].lazy * (right - left + 1);
        if (left != right) {
          arr[index * 2].lazy += arr[index].lazy;
          arr[index * 2 + 1].lazy += arr[index].lazy;
        }
        arr[index].lazy = 0;
      }
      if (right < rangeLeft || rangeRight < left)
        return;
      if (rangeLeft <= left && right <= rangeRight) {
        arr[index].value += val * (right - left + 1);
        if (left != right) {
          arr[index * 2].lazy += val;
          arr[index * 2 + 1].lazy += val;
        }
      } else {
        int middle = (left + right) / 2;
        addLazy(left, middle, rangeLeft, rangeRight, val, index * 2);
        addLazy(middle + 1, right, rangeLeft, rangeRight, val, index * 2 + 1);
        arr[index].value = arr[index * 2].value + arr[index * 2 + 1].value;
      }
    }
    long query(int left, int right, long rangeLeft, long rangeRight, int index) {
      if (arr[index].lazy != 0) {
        arr[index].value += arr[index].lazy * (right - left + 1);
        if (left != right) {
          arr[index * 2].lazy += arr[index].lazy;
          arr[index * 2 + 1].lazy += arr[index].lazy;
        }
        arr[index].lazy = 0;
      }
      if (rangeRight < left || right < rangeLeft) return 0;
      if (rangeLeft <= left && right <= rangeRight) return arr[index].value;

      int middle = (left + right) / 2;
      long leftVal = query(left, middle, rangeLeft, rangeRight, index * 2);
      long rightVal = query(middle + 1, right, rangeLeft, rangeRight, index * 2 + 1);
      return leftVal + rightVal;
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    int K = Integer.parseInt(line.nextToken());
    long arr[] = new long[N];
    for (int i = 0; i < N; i += 1) {
      arr[i] = Long.parseLong(br.readLine());
    }
    SegtreeWithLazy segTree = new SegtreeWithLazy(arr);

    for (int i = 0; i < M + K; i += 1) {
      line = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(line.nextToken());
      if (type == 1) {
        long from = Long.parseLong(line.nextToken()) - 1;
        long to = Long.parseLong(line.nextToken()) - 1;
        long val = Long.parseLong(line.nextToken());
        segTree.addLazy(0, arr.length - 1, from, to, val, 1);
      } else if (type == 2) {
        long from = Long.parseLong(line.nextToken()) - 1;
        long to = Long.parseLong(line.nextToken()) - 1;
        System.out.println(segTree.query(0, arr.length - 1, from, to, 1));
      }
    }

  }
}
