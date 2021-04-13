package ClubHomework;

import java.util.Scanner;

public class GiHyeon10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int numbers[] = new int[num];
		
		int i;
		for(i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int max = numbers[0], min = numbers[0];
		for(i = 0; i < num - 1; i++) {
			if(max < numbers[i + 1]) {
				max = numbers[i + 1];
			}
			if(min > numbers[i + 1]) {
				min = numbers[i + 1];
			}
		}

		System.out.printf("%d %d", max, min);
	}

}
