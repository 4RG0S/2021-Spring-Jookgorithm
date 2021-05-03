package baekjoon;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Rollcake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rc = scanner.nextInt();
        int cc = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer> rl = new ArrayList<Integer>();

        for(int i = 0; i < rc; i++)
            rl.add(scanner.nextInt());
        scanner.close();

        rl.sort(null);

        int answer = 0;

        for(int i = 0; i < rc; i++) {
            if(rl.get(i) / 10.0 == 1.0) {
                answer += 1;
                rl.set(i, 0);
            }
            if(rl.get(i) / 10.0 == 2.0 && cc > 0) {
                answer += 2;
                cc -= 1;
                rl.set(i, 0);
            }
            if(rl.get(i) % 10 == 0 && cc > 0 && rl.get(i) != 0) {
                if(cc >= rl.get(i) / 10 - 1) {
                    cc -= rl.get(i) / 10 - 1;
                    answer += rl.get(i) / 10;
                    rl.set(i, 0);
                } else {
                    answer += cc;
                    cc = 0;
                    break;
                }
            }
        }
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(0);
        rl.removeAll(r);
        rc = rl.size();

        int i = 0;
        while(cc != 0 && i < rc) {
            if(rl.get(i) > 10) {
                answer++;
                cc--;
                rl.set(i, rl.get(i) - 10);
            } else if(rl.get(i) < 10) {
                i++;
            }
        }
        System.out.println(answer);

    }
}
