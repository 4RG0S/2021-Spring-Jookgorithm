package ClubHomework;

import java.util.Scanner;

public class GiHyeon2480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3;
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		int result, temp, temp2;
		if( num1 == num2 && num2 == num3) {
			result = 10000 + num1 * 1000;
			System.out.printf("%d", result);
		} else if(num1 == num2 || num2 == num3 || num1 == num3) {
			if (num1 == num2) {
				result = 1000 + num1 * 100;
				System.out.printf("%d", result);
			} else if(num2 == num3) {
				result = 1000 + num2 * 100;
				System.out.printf("%d", result);
			} else {
				result = 1000 + num1 * 100;
				System.out.printf("%d", result);
			}
		} else {
			if(num1 > num2) {
				temp = num1;
				num1 = num2;
				num2 = temp;
				}
			if(num2 > num3) {
				temp = num2;
				num2 = num3;
				num3 = temp;
			}
			result = num3 * 100;
			System.out.printf("%d", result);
			
		} 
	}

}

