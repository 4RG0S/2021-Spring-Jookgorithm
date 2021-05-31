package ARGOS;

import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt(); // 지출해야 할 가격
		int value = 1000 - money; // 거스름돈의 가격
		int count = 0;
		sc.close();
		
		int[] coin = {500, 100, 50, 10, 5, 1};
		
		while(value != 0) {
			for(int i = 0; i < 6; i++) {
				if(value / coin[i] >= 0) {
					count = count + value/coin[i];
					value = value % coin[i];
				}
			}
		}
		
		System.out.println(count);

	}

}
