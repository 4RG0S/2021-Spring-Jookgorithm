import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_1_16928 {
  static class Move{
    int dot, move;
    public Move(int dot, int move) {
      this.dot = dot;
      this.move = move;
    }
  }
  static int count[] = new int[101];
  static int move[];
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());
    Queue<Move> q = new LinkedList<>();
    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    move = new int[101];

    for (int i = 0; i < N + M; i++) {
      line = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(line.nextToken());
      int to = Integer.parseInt(line.nextToken());

      move[from] = to;
    }
    q.add(new Move(1, 0));
    while(!q.isEmpty()) {
      Move temp = q.poll();
      for (int i=1;i<=6;i++) {
        int moveTo = temp.dot + i;
        if (moveTo > 100)
          break;
        if (move[moveTo] != 0)
          moveTo = move[moveTo];
        if (count[moveTo] == 0 || count[moveTo] > temp.move + 1) {
          count[moveTo] = temp.move + 1;
          q.add(new Move(moveTo, temp.move + 1));
        }
      }
    }
    System.out.println(count[100]);
  }
}
