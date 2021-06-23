package baekjoon;

import java.util.Scanner;

public class CountingWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] a = scanner.nextLine().trim().split(" ");

        int answer = 0;
        for(int i = 0; i < a.length; i++) {
            if(!a[i].equals(" ") && !a[i].equals(""))
                answer++;
        }
        System.out.println(answer);
    }

}
