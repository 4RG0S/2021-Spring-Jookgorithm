package ARGOS;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int num = Factorial(N);
		System.out.println(num);
		
		
		
		sc.close();
	}
	public static int Factorial(int N) {
		if(N == 0 || N == 1) return 1;
		else return N * Factorial(N - 1);
	}
}
