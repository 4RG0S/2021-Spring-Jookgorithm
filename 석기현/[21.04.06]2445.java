package ClubHomework;

import java.util.Scanner;

public class GiHyeon2445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int i, j, k, l;
		for(i = 1; i <= num; i++) {
			for(j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for(k = 1; k <= (num-i) * 2; k++) {
				System.out.print(" ");
			}
			for(l = 1; l <= i; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(i = 1; i <= num - 1; i++) {
			for(j = 1; j <= num - i; j++) {
				System.out.print("*");
			}
			for(k = 1; k <= i * 2; k++) {
				System.out.print(" ");
			}
			for(l = 1; l <= num - i; l++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
