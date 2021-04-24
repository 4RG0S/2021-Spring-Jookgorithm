package ClubHomework;

import java.util.Scanner;

public class GiHyoen10808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		int numbers[] = new int[26];
		int count[] = new int[26]; 
		
		int i, num = 97;
		for(i = 0; i < 26; i++) {
			numbers[i] = num;
			num++;
		}
		
		int j;
		for(i = 0; i < word.length(); i++) {
			for(j = 0; j < 26; j++) {
			 if ((int)word.charAt(i) == numbers[j]) {
				 count[j]++;
			 }
			}
		}
		
		for(i = 0; i < 26; i++) {
			System.out.printf("%d ", count[i]);
		}
	}

}
