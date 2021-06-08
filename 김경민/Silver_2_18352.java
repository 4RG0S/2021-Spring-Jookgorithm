import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Silver_2_18352 {
  static int min[];
  static List<List<Integer>> path = new ArrayList<>();
  static class Move {
    int distance, move;
    public Move(int distance, int move) {
      this.distance = distance;
      this.move = move;
    }
  }

  static void dijkstra(int start) {
    Queue<Move> q = new LinkedList<>();
    q.add(new Move(start, 0));
    min[start] = 0;
    while(!q.isEmpty()) {
      Move poll = q.poll();
      for (int there : path.get(poll.distance)) {
        if (min[there] == -1 || min[there] > poll.move + 1) {
          min[there] = poll.move + 1;
          q.add(new Move(there, poll.move + 1));
        }
      }
    }
  }
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());
    int result = 0;
    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    int K = Integer.parseInt(line.nextToken());
    int X = Integer.parseInt(line.nextToken());
    min = new int[N];
    for (int i=0;i<N;i++) {
      min[i] = -1;
      path.add(new ArrayList<>());
    }
    for (int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(line.nextToken()) - 1;
      int to = Integer.parseInt(line.nextToken()) - 1;
      path.get(from).add(to);
    }
    dijkstra(X-1);
    for (int i=0;i<N;i++) {
      if (min[i] == K) {
        result++;
        System.out.println(i + 1);
      }
    }
    if (result == 0)
      System.out.println(-1);
  }
}
