import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold_4_2665 {
  static int min[][];
  static boolean black[][];
  static int dx[] = {1, -1, 0, 0};
  static int dy[] = {0, 0, 1, -1};

  static class Dot {
    int x, y, countBlack;
    public Dot(int x, int y, int countBlack) {
      this.x = x;
      this.y = y;
      this.countBlack = countBlack;
    }
  }

  static boolean isRnage(int x, int y) {
    if (0 <= x && x < min[0].length && 0 <= y && y < min.length)
      return true;
    return false;
  }

  static void dijkstra() {
    Queue<Dot> q = new LinkedList<>();
    int isBlack = black[0][0] ? 1 : 0;
    q.add(new Dot(0, 0, isBlack));
    min[0][0] = isBlack;
    while(!q.isEmpty()) {
      Dot poll = q.poll();
      for (int i=0;i<4;i++) {
        int x = poll.x + dx[i];
        int y = poll.y + dy[i];
        if (!isRnage(x, y))
          continue;
        isBlack = black[y][x] ? 1 : 0;
        if (min[y][x] == -1 || min[y][x] > poll.countBlack + isBlack) {
          min[y][x] = poll.countBlack + isBlack;
          q.add(new Dot(x, y, min[y][x]));
        }
      }
    }
  }
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    min = new int[N][N];
    black = new boolean[N][N];
    for (int i=0;i<N;i++) {
      String line = br.readLine();
      for (int j=0;j<N;j++) {
        char ch = line.charAt(j);
        min[i][j] = -1;
        black[i][j] = (ch == '0');
      }
    }
    dijkstra();
    System.out.println(min[N-1][N-1]);
  }
}
