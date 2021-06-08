package ClubHomework;

import java.util.Scanner;

public class GiHyeon11653 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int i, temp = num;
		for (i = 2; i * i < num + 1; i++) {
			while (temp % i == 0) {
				System.out.println(i);
				temp = temp / i;
			}
		}
		if (!(temp == 1)) {
			System.out.println(temp);
		}
	}
}
