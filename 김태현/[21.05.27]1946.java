package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NewRecruits {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];
            String[] tmp;
            for(int j = 0; j < N; j++) {
                tmp = br.readLine().split(" ");
                rank[Integer.parseInt(tmp[0])] = Integer.parseInt(tmp[1]);
            }
            int answer = 0;
            int min = rank[1];
            for(int j = 1; j <= N; j++) {
                if(rank[j] <= min) {
                    answer++;
                    min = rank[j];
                }
            }
            System.out.println(answer);

        }

    }

}
