package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class SafeArea {

    static int N;

    static int countSafeArea(int[][] map, int height) {
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] >= height && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(i + " " + j);
                    while(queue.size() != 0) {
                        String[] tmp = queue.poll().split(" ");
                        int[] co = {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};
                        if(co[0] != 0) {
                            if(map[co[0] - 1][co[1]] >= height && !visited[co[0] - 1][co[1]]) {
                                visited[co[0] - 1][co[1]] = true;
                                queue.offer((co[0] - 1) + " " + (co[1]));
                            }
                        }
                        if(co[1] != 0) {
                            if(map[co[0]][co[1] - 1] >= height && !visited[co[0]][co[1] - 1]) {
                                visited[co[0]][co[1] - 1] = true;
                                queue.offer((co[0]) + " " + (co[1] - 1));
                            }
                        }
                        if(co[0] != N - 1) {
                            if(map[co[0] + 1][co[1]] >= height && !visited[co[0] + 1][co[1]]) {
                                visited[co[0] + 1][co[1]] = true;
                                queue.offer((co[0] + 1) + " " + (co[1]));
                            }
                        }
                        if(co[1] != N - 1) {
                            if(map[co[0]][co[1] + 1] >= height && !visited[co[0]][co[1] + 1]) {
                                visited[co[0]][co[1] + 1] = true;
                                queue.offer((co[0]) + " " + (co[1] + 1));
                            }
                        }
                    }
                    count++;
                }

            }
        }

        return count;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        String[] tmp;

        for(int i = 0; i < N; i++) {
            tmp = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(tmp[j]);
        }

        int max = 0;
        int p = 1;
        int height = 0;

        while(p != 0) {
            int ans = countSafeArea(map, height);
            if(ans > max)
                max = ans;
            p = ans;
            height++;
        }
        System.out.println(max);

    }

}
