import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver_4_12789 {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer line = new StringTokenizer(br.readLine());
    Queue<Integer> line_one = new LinkedList<>();
    Stack<Integer> line_two = new Stack<>();

    for (int i=0;i<N;i++) {
      line_one.add(Integer.parseInt(line.nextToken()));
    }
    int index = 1;
    boolean failed = false;
    while(true) {
      if (line_one.isEmpty()) {
        break;
      }
      if (!line_two.isEmpty() && line_two.peek() == index) {
        line_two.pop();
        index++;
        continue;
      }
      if (!line_one.isEmpty()) {
        line_two.push(line_one.poll());
      }
    }
    while(!line_two.isEmpty()) {
      if (line_two.peek() != index) {
        failed = true;
        break;
      }
      index++;
      line_two.pop();
    }
    if (failed) {
      System.out.println("Sad");
    } else {
      System.out.println("Nice");
    }
  }
}
