package baekjoon;

import java.util.Scanner;
import java.util.ArrayList;

public class AtoB {

    static ArrayList<Integer> a = new ArrayList<Integer>();

    static void atob(int target, long n, int count) {
        if(target != n) {
            if(n < target) {
                atob(target, Long.parseLong(Long.toString(n) + "1"), count + 1);
                atob(target, n * 2, count + 1);
            }
        } else {
            a.add(count);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        atob(B, A, 1);

        int answer = 2147483647;

        if(a.size() == 0) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) < answer) {
                answer = a.get(i);
            }
        }
        System.out.println(answer);

    }
}
