package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class KangsanCamping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s_answer = "";
        int case_count = 1;
        while(true) {
            String[] s = br.readLine().split(" ");
            int[] n = {Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])};
            if(n[0] == 0 && n[1] == 0 && n[2] == 0)
                break;
            int answer = (int)(n[2] / n[1]) * n[0];
            if((n[2] % n[1]) > n[0])
                answer += n[0];
            else
                answer += n[2] % n[1];
            s_answer += "Case " + case_count + ": " + answer + "\n";
            case_count++;
        }
        System.out.println(s_answer);
    }
}
