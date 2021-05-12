package ClubHomework;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
 
 
public class GiHyeon1181 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String[] array = new String[num];
		sc.nextLine();
		
		int i;
		for (i = 0; i < num; i++) {
			array[i] = sc.nextLine();
		}
		
		Arrays.sort(array, new Comparator<String>() {
			public int compare(String a, String b) {
				if (a.length() == b.length()) {
					return a.compareTo(b);
				} else {
					return a.length() - b.length();
				}
			}
		});
 
 
		System.out.println(array[0]);	
		for (i = 0; i < num - 1; i++) {
			if (!array[i + 1].equals(array[i])) {
				System.out.println(array[i + 1]);
			}
		}
	}
 
}