package ClubHomework;

import java.util.Scanner;

public class GiHyeon1475 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int count[] = new int[10];
		
		int i;
		for(;;) {
			i = num % 10;
			if(i == 6 || i == 9) {
				count[9]++;
			} else {
				count[i]++;
			}
			num = num / 10;
			if(num == 0) break;
		}
		
		int max = 0;
		for(i = 0; i < 9; i++) {
			if(max < count[i]) {
				max = count[i];
			}
		}
		
		int real;
		if(count[9] % 2 == 0) {
			real = count[9] / 2;
		} else {
			real = count[9] / 2 + 1;
		}
		
		if(max <= real) {
			System.out.printf("%d", real);
		} else {
			System.out.printf("%d", max);
		}
	}
}
