package ARGOS;

import java.util.Scanner;

public class Remainder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[10];
		int samecnt = 0;
		int result = 0;
		
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt() % 42;
		}
		for(int i = 0; i < 10; i++) {
			samecnt = 0;
			for (int j = i + 1; j < 10; j++) { 
				if(num[i] == num[j]) {
				samecnt = samecnt + 1;
				}
			}
			if(samecnt == 0) {
				result++;
			}
		}
		System.out.println(result);
		sc.close();
	}

}
