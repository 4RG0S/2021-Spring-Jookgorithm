package ARGOS;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num [] = new int[3];
		int temp = 0;
		
		while (true) {
			
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
		
		if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
			break;
		}
		if(num[0]*num[0] + num[1]*num[1] == num[2]*num[2]) {
			System.out.println("right");
		}
		else {
			System.out.println("wrong");
		}
		
		}
		sc.close();
	}
}
