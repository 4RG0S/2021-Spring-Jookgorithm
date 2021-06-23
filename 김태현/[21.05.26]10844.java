package baekjoon;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class NumberingComplex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();
        int[][] map = new int[count][count];

        for(int i = 0; i < count; i++) {
            String[] tmp = scanner.nextLine().split("");
            for(int j = 0; j < count; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        Queue<String> queue = new LinkedList<>();
        int[] answer = new int[count * count];
        boolean[][] counted = new boolean[count][count];
        int complex = 0;

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < count; j++) {
                if(map[i][j] == 1 && !counted[i][j]) {
                    int c = 1;
                    counted[i][j] = true;
                    queue.offer(i + " " + j);
                    while(queue.size() != 0) {
                        String[] tmp = queue.poll().split(" ");
                        int[] co = {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};
                        if(co[0] != 0) {
                            if(map[co[0] - 1][co[1]] == 1 && !counted[co[0] - 1][co[1]]) {
                                counted[co[0] - 1][co[1]] = true;
                                queue.offer((co[0] - 1) + " " + (co[1]));
                                c++;
                            }
                        }
                        if(co[1] != 0) {
                            if(map[co[0]][co[1] - 1] == 1 && !counted[co[0]][co[1] - 1]) {
                                counted[co[0]][co[1] - 1] = true;
                                queue.offer((co[0]) + " " + (co[1] - 1));
                                c++;
                            }
                        }
                        if(co[0] != count - 1) {
                            if(map[co[0] + 1][co[1]] == 1 && !counted[co[0] + 1][co[1]]) {
                                counted[co[0] + 1][co[1]] = true;
                                queue.offer((co[0] + 1) + " " + (co[1]));
                                c++;
                            }
                        }
                        if(co[1] != count - 1) {
                            if(map[co[0]][co[1] + 1] == 1 && !counted[co[0]][co[1] + 1]) {
                                counted[co[0]][co[1] + 1] = true;
                                queue.offer((co[0]) + " " + (co[1] + 1));
                                c++;
                            }
                        }
                    }
                    answer[complex] = c;
                    complex++;
                }

            }
        }

        int[] a = new int[complex];
        for(int i = 0; i < complex; i++)
            a[i] = answer[i];
        Arrays.sort(a);
        System.out.println(complex);
        for(int i = 0; i < complex; i++)
            System.out.println(a[i]);

    }

}
