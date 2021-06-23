package baekjoon;

import java.util.Scanner;

public class HighRise {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        int[] height = new int[count];

        for(int i = 0; i < count; i++)
            height[i] = scanner.nextInt();

        int max = 0;

        for(int i = 0; i < count; i++) {
            int answer = 0;
            for(int j = i - 1; j >= 0; j--) {
                double a, b; // y = ax + b
                a = (double)(height[i] - height[j]) / ((i + 1) - (j + 1));
                b = height[i] - (a * (i + 1));
                for(int k = i - 1; k >= j; k--) {
                    if(a * (k + 1) + b <= height[k] && k != j)
                        break;
                    if(k == j) answer++;
                }
            }
            for(int j = i + 1; j < count; j++) {
                double a, b; // y = ax + b
                a = (double)(height[i] - height[j]) / ((i + 1) - (j + 1));
                b = height[i] - (a * (i + 1));
                for(int k = i + 1; k <= j; k++) {
                    if(a * (k + 1) + b <= height[k] && k != j)
                        break;
                    if(k == j) answer++;
                }
            }
            max = Math.max(answer, max);
        }

        System.out.println(max);

    }
    
}
