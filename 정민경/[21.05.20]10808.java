package ARGOS;

import java.util.Scanner;

public class Num_Of_Alphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		int[] num = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			int a = s.charAt(i) - 'a';
			num[a]++;
			
		}
		for(int i = 0; i < 26; i++) {
			System.out.print(num[i] + " ");
			
		}
		
		sc.close();
	}

}
