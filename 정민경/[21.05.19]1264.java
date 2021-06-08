package ARGOS;

import java.util.Scanner;

public class Vowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[100];
		int count = 0;
		int line = 0;
		
		loop:
		for(int i = 0; i < 100; i++) {
			count = 0;
			String str = sc.nextLine();
			for(int j = 0; j < str.length(); j++) {
				char a = str.charAt(j);
				if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
				   a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
					count = count + 1;
					cnt[i] = count;
				}
				else if(a == '#') {
					line = i;
					break loop;
				}
			}
		}
		for(int i = 0; i < line; i++) {
			System.out.println(cnt[i]);	
		}
		
		sc.close();

	}

}
