package baekjoon;

import java.util.Scanner;

public class Gazzzua {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        int[] chart = new int[count];

        for(int i = 0; i < count; i++)
            chart[i] = scanner.nextInt();
        scanner.close();

        int answer = 0;
        int locate = 0;
        int locate_pre = 0;
        while(locate < count) {
            int tmp = 0;
            for(int i = locate; i < count; i++) {
                if (tmp <= chart[i]) {
                    tmp = chart[i];
                    locate = i + 1;
                }
            }
            tmp = 0;
            for(int i = locate_pre; i < locate - 1; i++) {
                tmp += chart[i];
            }
            answer += chart[locate - 1] * (locate - locate_pre - 1) - tmp;
            locate_pre = locate;
        }
        System.out.println(answer);

    }
}
