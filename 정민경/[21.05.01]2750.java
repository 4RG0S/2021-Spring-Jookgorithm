package ARGOS;

import java.util.Arrays;
import java.util.Scanner;

public class Bottom_To_Top {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int num [] = new int[N];
		int temp = 0;
		
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		for (int j = 0; j < num.length; j++) {
			for (int k = j + 1; k < num.length; k++) {
			 if(num[j] > num[k]) {
				temp = num[j];
				num[j] = num[k];
				num[k] = temp;
			 }
			}
		}
		
		for (int l = 0; l < num.length; l++) {
			System.out.println(num[l]);
		}
		
		sc.close();
	}

}
