import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Gold_5_16234 {
  static int people[][];
  static int N, L, R;
  static boolean allClosed = false;
  static int dx[] = {1, -1, 0, 0};
  static int dy[] = {0, 0, 1, -1};

  static class dot{
    int x, y;
    public dot(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static boolean isRange(int x, int y) {
    if (0 <= x && x < N && 0 <= y && y < N)
      return true;
    else
      return false;
  }
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());
    N = Integer.parseInt(line.nextToken());
    L = Integer.parseInt(line.nextToken());
    R = Integer.parseInt(line.nextToken());
    people = new int[N][N];

    for (int i=0;i<N;i++) {
      line = new StringTokenizer(br.readLine());
      for (int j=0;j<N;j++) {
        people[i][j] = Integer.parseInt(line.nextToken());
      }
    }
    int result = 0;
    while(!allClosed) {
      allClosed = true;
      Queue<dot> search = new LinkedList<>();
      Queue<dot> apply = new LinkedList<>();
      boolean isVisit[][] = new boolean[N][N];
      for (int i=0;i<N;i++) {
        for (int j=0;j<N;j++) {
          if (isVisit[i][j])
            continue;
          int sum = people[i][j];
          int count = 1;
          isVisit[i][j] = true;
          search.add(new dot(j, i));
          apply.add(new dot(j, i));
          while(!search.isEmpty()) {
            dot temp = search.poll();
            for (int k=0;k<4;k++) {
              int x = temp.x + dx[k];
              int y = temp.y + dy[k];
              if (!isRange(x, y) || isVisit[y][x])
                continue;
              int diff = Math.abs(people[y][x] - people[temp.y][temp.x]);
              if (L <= diff && diff <= R) {
                allClosed = false;
                isVisit[y][x] = true;
                sum += people[y][x];
                count++;
                apply.add(new dot(x, y));
                search.add(new dot(x, y));
              }
            }
          }
          int val = sum / count;
          while(!apply.isEmpty()) {
            dot temp = apply.poll();
            people[temp.y][temp.x] = val;
          }
        }
      }
      result++;
    }
    System.out.println(result - 1);
  }
}
