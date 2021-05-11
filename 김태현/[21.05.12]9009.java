package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MakeByFibonacci {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int[] F = new int[45];
        F[0] = 1;
        F[1] = 1;
        for(int i = 2; i < 45; i++)
            F[i] = F[i - 1] + F[i - 2];

        for(int i = 0; i < count; i++) {
            int n = Integer.parseInt(br.readLine());

            int a = 1;
            while(F[a] < n)
                a++;
            if(F[a] != n)
                a--;

            int[] answer = new int[45];
            int j = 0;
            int c = 0;
            while(c != n) {
                int f = F[a];
                if(c + f <= n) {
                    answer[j] = f;
                    j++;
                    a--;
                    c += f;
                } else {
                    a--;
                }
            }
            for(j -= 1 ; j >= 0; j--) {
                System.out.print(answer[j] + " ");
            }
            System.out.println();
        }
    }

}
