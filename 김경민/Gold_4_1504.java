import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Gold_4_1504 {

	static List<List<path>> list = new ArrayList<>();
	static int fir, se;
	static int dist[];

	static class path {
		int dest, len;
		public path(int dest, int len)
		{
			this.dest = dest;
			this.len = len;
		}
	}

  static void initDist(int size) {
    dist = new int[size];
    for (int i=0;i<dist.length;i++) {
      dist[i] = -1;
    }
  }

  static void dijkstra(int size, int from, int to) {
    Queue<path> q = new LinkedList<>();
    initDist(size);
    q.add(new path(from, 0));
    dist[from] = 0;
    while(!q.isEmpty()) {
      path poll = q.poll();
      for (path dest : list.get(poll.dest)) {
        if (dist[dest.dest] == -1 || dist[dest.dest] > poll.len + dest.len) {
          dist[dest.dest] = poll.len + dest.len;
          q.add(new path(dest.dest, dist[dest.dest]));
        }
      }
    }
  }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer num = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(num.nextToken());
		int E = Integer.parseInt(num.nextToken());

		for(int i=0;i<N+1;i++)
		{
			list.add(new ArrayList<>());
		}
		for(int i=0;i<E;i++)
		{
			StringTokenizer line = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			int len = Integer.parseInt(line.nextToken());
			list.get(from).add(new path(to, len));
			list.get(to).add(new path(from, len));
		}
		StringTokenizer visit = new StringTokenizer(br.readLine());
		fir = Integer.parseInt(visit.nextToken());
		se = Integer.parseInt(visit.nextToken());
    // 1 -> fir -> se -> N
    dijkstra(N + 1, 1, fir);
    int firA = dist[fir];
    dijkstra(N + 1, fir, se);
    int firB = dist[se];
    dijkstra(N + 1, se, N);
    int firC = dist[N];
    int firV = (firA == -1 || firB == -1 || firC == -1) ? Integer.MAX_VALUE : firA + firB + firC;
    // 1 -> se -> fir -> N
		dijkstra(N + 1, 1, se);
    int seA = dist[se];
    dijkstra(N + 1, se, fir);
    int seB = dist[fir];
    dijkstra(N + 1, fir, N);
    int seC = dist[N];
    int seV = (seA == -1 || seB == -1 || seC == -1) ? Integer.MAX_VALUE : seA + seB + seC;
    if (firV == Integer.MAX_VALUE && seV == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(Integer.min(firV, seV));
    }
	}

}
