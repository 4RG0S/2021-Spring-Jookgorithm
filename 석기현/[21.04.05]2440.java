package ClubHomework;

import java.util.Scanner;

public class GiHyeon2440 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int i, j;
		for(i = num; i > 0; i--) {
			for(j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
