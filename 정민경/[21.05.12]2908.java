package ARGOS;

import java.util.Scanner;

public class Compare_rev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int num = ((a % 10)*100) + (((a % 100)/10)*10) + (a / 100);
		int num1 = ((b % 10)*100) + (((b % 100)/10)*10) + (b / 100);
	
		System.out.println(num > num1 ? num : num1);
		
		sc.close();

	}

}
