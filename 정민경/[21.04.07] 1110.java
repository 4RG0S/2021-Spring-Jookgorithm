package week6;

import java.util.Scanner;

public class P_Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = 0; //첫번째 수
		int b = 0; //두번째 수
		int c = 0; //빈자리
		int count = 0;
		
		a = N/10;
		b = N%10;
		
		while (true) {
		    count++;
			c = b;
			b = (a + b)%10;
			a = c;
			
			if (N == a*10 + b) {
				break;
			}
		}
		System.out.println(count);
	
		sc.close();
     }
        	
}
