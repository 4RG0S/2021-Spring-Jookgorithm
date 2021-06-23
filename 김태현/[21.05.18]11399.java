package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class WithdrawFromATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        int[] t = new int[n];

        for(int i = 0; i < n; i++)
            t[i] = Integer.parseInt(st[i]);

        Arrays.sort(t);
        int answer = 0;

        for(int i = 0; i < n; i++) {
            int tmp = 0;
            for(int j = 0; j <= i; j++)
                tmp += t[j];
            answer += tmp;
        }

        System.out.println(answer);

    }

}
