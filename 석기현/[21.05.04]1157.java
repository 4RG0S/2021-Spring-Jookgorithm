package ClubHomework;

import java.util.Scanner;

public class GiHyeon1157 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String word = sc.next();

		int[] Alphabet = new int[26]; // 65 ~ 90(대문자), 97~122(소문자)
		
		int i;
		for (i = 0; i < word.length(); i++) {
 
			if (65 <= word.charAt(i) && word.charAt(i) <= 90) {
				Alphabet[word.charAt(i) - 65]++;
			}	
			
			else {
				Alphabet[word.charAt(i) - 97]++;
			}
		}
 
 
		int max = -1;
		char result = '?';
 
		for (i = 0; i < 26; i++) {
			
			if (Alphabet[i] == max) {
				result = '?';
			}
		
			else if (Alphabet[i] > max) {
				max = Alphabet[i];
				result = (char) (i + 65); 
			}
		}
 
		System.out.print(result);
	}
 
}