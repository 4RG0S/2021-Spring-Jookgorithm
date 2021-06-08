package baekjoon;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String c = scanner.next();
        long a = Long.parseLong(c.substring(0, c.length() - 2)) * 100;
        long b = scanner.nextInt();

        int answer = a % b == 0 ? 0 : (int) (b - (a % b));
        System.out.printf("%02d", answer);

    }
}
