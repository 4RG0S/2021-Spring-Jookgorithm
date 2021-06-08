package ARGOS;

import java.util.Scanner;

public class Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[][] word = new char[5][15];
		for(int i = 0; i < 5; i++) {
			String str = sc.next();
			for(int j = 0; j < str.length(); j++) {
				word[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				if(word[j][i] == ' ' || word[j][i] == '\0') {
					continue;
				}
				else {
				System.out.print(word[j][i]);
				}
			}
		}
		sc.close();
	}

}
