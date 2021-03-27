import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Oil {

	static int m, n, oil;
	
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());

		int[][] Score = new int[m][n];
		String s;
		Node start = null, end = null;
		for (int i = 0; i < m; i++) {
			s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == 'S') {
					start = new Node(j, i);
				} else if (s.charAt(j) == 'E') {
					end = new Node(j, i);
				} else {
					Score[i][j] = s.charAt(j) - '0';
				}		
			}
		}

		a_star(start, end, Score);
	}

	private static double huris(Node start, Node end) {
		return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
	}

	private static void a_star(Node start, Node end, int[][] Score) {
		HashSet<Node> openSet = new HashSet<Node>();
		openSet.add(start);

		int INF = Integer.MAX_VALUE;

		int[][] gScore = new int[m][n];
		double[][] fScore = new double[m][n];
		boolean[][] visit = new boolean[m][n];
		visit[start.y][start.x] = true;

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (j != start.x || i != start.y) {
					gScore[i][j] = INF;
					fScore[i][j] = INF;
				} else {
					gScore[i][j] = 0;
					fScore[i][j] = huris(start, end);
				}
			}

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		int result;
		boolean first;
		
		while (!openSet.isEmpty()) {
			
			first = true;
			Node current = null;
			
			for (Node n : openSet) {
				if(first) {
					current = n;
					first = false;
				}
				else
					if (fScore[n.y][n.x] < fScore[current.y][current.x]) {
						current = n;
					}
			}

			if (current.x == end.x && current.y == end.y) {
				result = (int) (oil - fScore[current.y][current.x]);
				if (result >= 0)
					System.out.println(result);
				else
					System.out.println("Not enough oil!");
			}

			openSet.remove(current);

			int nx, ny, tentative = 0;
			Node temp;

			for (int i = 0; i < 4; i++) {
				nx = current.x + dx[i];
				ny = current.y + dy[i];
				temp = new Node(nx, ny);
				if (0 <= nx && nx < n && 0 <= ny && ny < m && !visit[ny][nx]) {
					tentative = gScore[current.y][current.x] + Score[ny][nx];
					if (tentative < gScore[ny][nx]) {
						gScore[ny][nx] = tentative;
						fScore[ny][nx] = gScore[ny][nx] + huris(temp, end);
						visit[ny][nx] = true;
						openSet.add(temp);
					}
				}
			}
		}
	}
}