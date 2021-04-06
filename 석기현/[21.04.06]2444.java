package ClubHomework;

import java.util.Scanner;

public class GiHyeon2444 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		
		int i, j, k;
		for(i = 1; i <= num ; i++) {
			for(j = 0; j < num-i; j++)
				System.out.print(" ");
			for(k = 0; k < i*2-1; k++)
				System.out.print("*");
			
			System.out.println();
		}
		
		for(i = num-1; i >= 0 ; i--) {
			for(j = 0; j < num-i; j++)
				System.out.print(" ");
			for(k = 0; k < i*2-1; k++)
				System.out.print("*");
			
			System.out.println();
		}
	}
	}


