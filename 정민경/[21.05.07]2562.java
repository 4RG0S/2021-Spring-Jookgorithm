package ARGOS;

import java.util.Scanner;

public class Max_Num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num[] = new int[9];
		
		for(int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
		} //배열 생성
		
		int count = 1;
		int max = num[0];
		int value = 0;
		for (int j = 1; j < 9; j++) {
			if (max >= num[j]) {
				value = max;
			}
			else if (max < num[j]) {
				value = num[j];
				max = num[j];
				count = j + 1;
				
			}
		}
		System.out.println(value);
		System.out.println(count);
		
		sc.close();
	}

}
