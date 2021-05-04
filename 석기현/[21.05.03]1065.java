package ClubHomework;

import java.util.Scanner;

public class GiHyeon1065 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.print(condition.cal(num));
	}
}
 
class condition {
		
		
		static int cal(int num) {
			
			if(num < 100) {
				return num;
			}
			
			else {
				int firstnumber = 99;
				int i;
				
				for(i = 100; i < num + 1; i++) {
					
					int a = i % 10;
					int b = (i / 10) % 10;
					int c= i / 100;
					
					if((b - a) == (c - b)) {
						firstnumber = firstnumber + 1;
					}
				}
				
				return firstnumber;
			}
		}
}

 
		
		
 

