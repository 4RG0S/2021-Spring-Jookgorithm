package ClubHomework;

import java.util.Scanner;

public class GiHyeon1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int i, j, newnum, count = 0, result = 0;
		for(i = 0; i < num; i++) {
			
			newnum = sc.nextInt();
			count = 0;
			
			for(j = 2; j <= newnum; j++) {
				
				if(newnum % j == 0) {
					count++;
				}
			}
			
			if(count == 1) {
				result++;
			}
			
		}
		System.out.print(result);

	}

}
