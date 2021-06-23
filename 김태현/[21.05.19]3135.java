package baekjoon;

import java.util.Scanner;
import java.lang.Math;

public class JunhaRadio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int current = scanner.nextInt();
        int target = scanner.nextInt();
        scanner.nextLine();

        int count = scanner.nextInt();
        scanner.nextLine();
        int[] favorite = new int[count];

        for(int i = 0; i < count; i++) {
            favorite[i] = scanner.nextInt();
            scanner.nextLine();
        }

        int a = -1;
        int min = Math.abs(current - target);

        for(int i = 0; i < count; i++) {
            int tmp = Math.abs(favorite[i] - target);
            if(tmp < min) {
                min = tmp;
                a = i;
            }
        }

        if(a == -1)
            System.out.println(min);
        else
            System.out.println(1 + min);
    }

}
