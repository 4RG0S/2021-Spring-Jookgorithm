package ClubHomework;

import java.util.Scanner;

public class GiHyeon2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc = new Scanner(System.in);
		
		int i, j, result = 1;
		for(i = 0; i < 3; i++) {
			j = sc.nextInt();
			result = result * j;
		} 
		
		int count[] = new int[10];
		
		for(;;) {
			
			i = result % 10;
			count[i]++;
			
			result = result / 10;
			if(result == 0) break;
		}
		
		for(i = 0; i < 10; i++) {
			System.out.printf("%d\n", count[i]);
		}
	}

}
