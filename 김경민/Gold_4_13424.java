import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Gold_4_13424 {
  static class Path {
    int dest, len;
    public Path(int dest, int len) {
      this.dest = dest;
      this.len = len;
    }
  }
  static List<List<Path>> list;
  static int min[][];

  static void dijkstra(int index, int here) {
    Queue<Path> q = new LinkedList<>();
    min[index][here] = 0;
    q.add(new Path(here, 0));
    while(!q.isEmpty()) {
      Path poll = q.poll();
      for (Path there : list.get(poll.dest)) {
        if (min[index][there.dest] == -1 || min[index][there.dest] > min[index][poll.dest] + there.len) {
          min[index][there.dest] = min[index][poll.dest] + there.len;
          q.add(there);
        }
      }
    }
  }
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i=0;i<T;i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(line.nextToken());
      int M = Integer.parseInt(line.nextToken());
      list = new ArrayList<>();
      for (int j=0;j<N+1;j++) {
        list.add(new ArrayList<>());
      }

      for (int j=0;j<M;j++) {
        line = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(line.nextToken());
        int to = Integer.parseInt(line.nextToken());
        int val = Integer.parseInt(line.nextToken());
        list.get(from).add(new Path(to, val));
        list.get(to).add(new Path(from, val));
      }
      int K = Integer.parseInt(br.readLine());
      int students[] = new int[K];
      line = new StringTokenizer(br.readLine());
      min = new int[K+1][N+1];
      for (int j=0;j<K+1;j++) {
        for (int k=0;k<N+1;k++) {
          min[j][k] = -1;
        }
      }
      for (int j=1;j<=K;j++) {
        dijkstra(j, Integer.parseInt(line.nextToken()));
      }
      int resultIndex = 0;
      int minValue = Integer.MAX_VALUE;
      for (int j=1;j<=N;j++) {
        int sum = 0;
        for (int k=1;k<=K;k++) {
          sum += min[k][j];
        }
        resultIndex = (minValue > sum) ? j : resultIndex;
        minValue = (minValue > sum) ? sum : minValue;
      }
      System.out.println(resultIndex);
    }
  }
}
