package ARGOS;

import java.util.Scanner;

public class Star_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			for(int j = N; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 0; k < i; k++) {
			System.out.print("*");
			}
			System.out.println();
		}
		
		
		sc.close();

        	
}
}
