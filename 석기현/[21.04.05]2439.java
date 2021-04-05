package ClubHomework;

import java.util.Scanner;

public class GiHyeon2439 {
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
 
		int num = sc.nextInt();
 
		int i, j, k;
		for (i = 1; i <= num; i++) {
			for (j = 1; j <= num - i; j++) {
				System.out.print(" ");
			}
			for (k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}