package ARGOS;

import java.util.Arrays;
import java.util.Scanner;

public class Max_Min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num [] = new int[N];
		
		for (int i = 0; i < N; i++) {
			num [i] = sc.nextInt();
		}
		
		int Max = num[0];
		int Min = num[0];
		
		for (int j = 0; j < N; j++) {
			if (num[j] > Max) {
				Max = num[j];
			}
			else if(num[j] < Min) {
				Min = num[j];
			}
		}
		
		System.out.println(Min + " " + Max);
		
		sc.close();
	}

}
