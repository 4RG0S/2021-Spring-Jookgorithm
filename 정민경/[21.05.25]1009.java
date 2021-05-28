package ARGOS;

import java.util.Scanner;

public class Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int a = 0;
		int b = 0;
		int r = 0;
		int[] result = new int[T];
		
		for(int i = 0; i < T; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			r = 1;
			for(int j = 0; j < b; j++) {
				r = (r*a)%10;
			}
			if(r == 0) {
				r = 10;
			}
			result[i] = r;
		}
		
		for(int i = 0; i < T; i++) {
		System.out.println(result[i]);
		}
		
		sc.close();

	}

}
