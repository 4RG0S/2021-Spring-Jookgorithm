package baekjoon;

import java.util.Scanner;

public class PlusCycle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int answer = 0;
        int tmp = 100;
        int a = target;
        int b = 0;
        int c = 0;

        while(tmp != target) {
            if(a / 10 == 0) {
                b = 0;
                c = a;
            } else {
                b = a / 10;
                c = a % 10;
            }
            tmp = Integer.parseInt(Integer.toString(c) + Integer.toString((b + c) % 10));
            a = tmp;
            answer++;
        }

        System.out.println(answer);
    }
}
