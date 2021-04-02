package baekjoon;

import java.util.Scanner;

public class prompt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = scanner.nextInt();
		scanner.nextLine();
		String[] str = new String[count];
		
		for(int i = 0; i < count; i++) {
			str[i] = scanner.nextLine();
		}
		
		scanner.close();
		
		String answer = "";
		
		boolean isDiff = false;
		
		for(int i = 0; i < str[0].length(); i++) {
			for(int j = 0; j < count; j++) {
				if(j == count - 1) break;
				if(str[j].charAt(i) != str[j + 1].charAt(i)) {
					isDiff = true;
					break;
				}
					
			}
			if(isDiff) {
				isDiff = false;
				answer += "?";
			} else 
				answer += str[0].charAt(i);
		}
		
		System.out.println(answer);
	}

}
