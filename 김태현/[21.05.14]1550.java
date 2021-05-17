package baekjoon;

import java.util.Scanner;
import java.lang.Math;

public class Hex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();

        System.out.println(Integer.parseInt(a, 16));

        int answer = 0;
        for(int i = 0; i < a.length(); i++) {
            int s = (int)Math.pow(16, a.length() - 1 - i);
            if(a.charAt(i) >= 48 && a.charAt(i) < 57)
                answer += Integer.parseInt(String.valueOf(a.charAt(i))) * s;
            else
                answer += ((int)a.charAt(i) - 55) * s;
        }
        System.out.println(answer);
    }

}
