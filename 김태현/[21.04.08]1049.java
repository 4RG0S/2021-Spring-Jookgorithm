package baekjoon;

import java.util.Scanner;

public class guitarstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int goal = scanner.nextInt();
		int count = scanner.nextInt();
		scanner.nextLine();
		int a = 0;
		int b = 0;
		for(int i = 0; i < count; i++) {
			if(i == 0) {
				a = scanner.nextInt();
				b = scanner.nextInt();
				scanner.nextLine();
				continue;
			}
			int input = scanner.nextInt();
			a = input <= a ? input : a;
			input = scanner.nextInt();
			b = input <= b ? input : b;
		}
		scanner.close();
		
		if(b * 6 <= a) {
			System.out.println(b * goal);
		} else {
			if(a <= b) {
				if(goal % 6 != 0) 
					System.out.println((goal / 6 + 1) * a);
				else 
					System.out.println((goal / 6) * a);
			} else {
				if(goal % 6 != 0) {
					int answer = (goal / 6) * a + ((goal - (goal / 6) * 6) * b) <= (goal / 6 + 1) * a ? 
							 (goal / 6) * a + ((goal - (goal / 6) * 6) * b) : (goal / 6 + 1) * a;
					System.out.println(answer);
				} else {
					int answer = (goal / 6) * a + ((goal - (goal / 6) * 6) * b) <= (goal / 6) * a ? 
							 (goal / 6) * a + ((goal - (goal / 6) * 6) * b) : (goal / 6) * a;
					System.out.println(answer);
				}
			}
		}
		

	}

}
