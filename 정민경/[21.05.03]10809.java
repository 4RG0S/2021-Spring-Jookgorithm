package ARGOS;

import java.util.*;

public class Find_Alpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		for(char c = 'a'; c <= 'z'; c++) {
			System.out.print(s.indexOf(c) + " ");	
		}
		
		sc.close();
	}

}
