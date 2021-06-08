package ClubHomework;

import java.util.Scanner;

public class GiHyeon2609 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		a = sc.nextInt();
		b = sc.nextInt();
 
		int realgcd = gcd.GCD(a, b);
 
		System.out.println(realgcd);
		System.out.println(a * b / realgcd);
 
	}	
}

class gcd {
	
	static int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
}