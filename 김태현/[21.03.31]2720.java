package baekjoon;

import java.util.Scanner;

public class laundrydong {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		String[] answer = new String[count];
		scanner.nextLine();
		
		int money = 0;
		int q = 0;
		int d = 0;
		int n = 0;
		int p = 0;
		
		for(int i = 0; i < count; i++) {
			money = Integer.parseInt(scanner.nextLine());
			q = 0;
			d = 0;
			n = 0;
			p = 0;
			while(true) {
				if(money >= 25) {
					money = money - 25;
					q++;
				}
				else 
					break;
			}
			while(true) {
				if(money >= 10) {
					money = money - 10;
					d++;
				}
				else 
					break;
			}
			while(true) {
				if(money >= 5) {
					money = money - 5;
					n++;
				}
				else 
					break;
			}
			while(true) {
				if(money >= 1) {
					money = money - 1;
					p++;
				}
				else 
					break;
			}
			answer[i] = Integer.toString(q) + " " + Integer.toString(d) + " " + Integer.toString(n) + " " + Integer.toString(p);
		}
		
		for(int i = 0; i < count; i++) {
			System.out.println(answer[i]);
		}

	}

}
