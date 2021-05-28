package ARGOS;

import java.util.Scanner;

public class Odd_Num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[7];
		int oddcnt = 0;
		int result = 0;
		
		for(int i = 0; i < 7; i++) {
			num[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 7; i++) {
			if(num[i] % 2 == 1) {
				oddcnt ++;
				result = result + num[i];
				if(min > num[i]) {
					min = num[i];
				}
			}
		}
		
		if(oddcnt == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
			System.out.println(min);
		}
		sc.close();
	}
}
