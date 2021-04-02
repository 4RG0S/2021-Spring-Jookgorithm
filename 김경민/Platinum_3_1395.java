import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Platinum_3_1395 {
  static class SegtreeWithLazy {
    static class Node {
      int count;
      boolean lazy;
      public Node(int count) {
        this.count = count;
        this.lazy = false;
      }
    }
    Node tree[];
    public SegtreeWithLazy(int N) {
      tree = new Node[N * 4];
      init(1, N, 1);
    }
    void init(int left, int right, int index) {
      if (left == right)
        tree[index] = new Node(0);
      else {
        int middle = (left + right) / 2;
        init(left, middle, index * 2);
        init(middle + 1, right, index * 2 + 1);
        tree[index] = new Node(0);
      }
    }
    void addLazy(int left, int right, int rangeLeft, int rangeRight, int index) {
      if (tree[index].lazy) {
        tree[index].count = (right - left + 1) - tree[index].count;
        if (left != right) {
          tree[index * 2].lazy = !tree[index * 2].lazy;
          tree[index * 2 + 1].lazy = !tree[index * 2 + 1].lazy;
        }
        tree[index].lazy = !tree[index].lazy;
      }
      if (right < rangeLeft || rangeRight < left)
        return;
      if (rangeLeft <= left && right <= rangeRight) {
        tree[index].count = (right - left + 1) - tree[index].count;
        if (left != right) {
          tree[index * 2].lazy = !tree[index * 2].lazy;
          tree[index * 2 + 1].lazy = !tree[index * 2 + 1].lazy;
        }
        return;
      }
      int middle = (left + right) / 2;
      addLazy(left, middle, rangeLeft, rangeRight, index * 2);
      addLazy(middle + 1, right, rangeLeft, rangeRight, index * 2 + 1);
      tree[index].count = tree[index * 2].count + tree[index * 2 + 1].count;
    }
    int query(int start, int end, int left, int right, int index) {
      if (tree[index].lazy) {
        tree[index].count = (end - start + 1) - tree[index].count;
        if (start != end) {
          tree[index * 2].lazy = !tree[index * 2].lazy;
          tree[index * 2 + 1].lazy = !tree[index * 2 + 1].lazy;
        }
        tree[index].lazy = !tree[index].lazy;
      }
      if (end < left || right < start)
        return 0;
      if (left <= start && end <= right) {
        return tree[index].count;
      }
      int middle = (start + end) / 2;
      int leftVal = query(start, middle, left, right, index * 2);
      int rightVal = query(middle + 1, end, left, right, index * 2 + 1);
      return leftVal + rightVal;
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    SegtreeWithLazy segTree = new SegtreeWithLazy(N);
    for (int i = 0; i < M; i += 1) {
      line = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(line.nextToken());
      if (type == 0) {
        int rangeLeft = Integer.parseInt(line.nextToken());
        int rangeRight = Integer.parseInt(line.nextToken());
        segTree.addLazy(1, N, rangeLeft, rangeRight, 1);
        // System.out.println(segTree.query(0, 99999, 0, 99999, 1));
      } else if (type == 1) {
        int rangeLeft = Integer.parseInt(line.nextToken());
        int rangeRight = Integer.parseInt(line.nextToken());
        System.out.println(segTree.query(1, N, rangeLeft, rangeRight, 1));
      }
    }
  }
}
