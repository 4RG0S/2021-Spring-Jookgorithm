package ClubHomework;

import java.util.Scanner;

public class GiHyeon10807 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int numbers[] = new int[num];
		
		int i;
		for(i = 0; i < num; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int findnumber = sc.nextInt();
		sc.close();
		
		int count = 0;
		for(i = 0; i < num; i++) {
			if(numbers[i] == findnumber) {
				count++;
			}
		}
		
		System.out.printf("%d", count);
		
		
	}

}
