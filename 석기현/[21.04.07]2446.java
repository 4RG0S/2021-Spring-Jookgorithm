package ClubHomework;

import java.util.Scanner;

public class GiHyeon2446 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		int num = sc.nextInt();

		int i, j, k;
		for (i = 0; i < num; i++) {
			for (j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (k = 0; k < (2*num-1) - (2*i); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (i = 0; i < num - 1; i++) {
			for (j = 1; j < (num-1) - i; j++) {	
				System.out.print(" ");
			}
			for (k = 0; k < 2*i + 3; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
