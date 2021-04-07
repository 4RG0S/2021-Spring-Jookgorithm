package ClubHomework;

import java.util.Scanner;

public class GiHyeon2752 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int i;
		int[] a = new int[3];
		for(i = 0; i < 3; i++) {
			a[i] = sc.nextInt();
		}
		
		int j;
		int temp;
		for(i = 0; i < 2; i++) {
			for(j = i + 1; j < 3; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			} 
		}
		
		for(i = 0; i < 3; i++) {
			System.out.printf("%d ",a[i]);
		}
	}

}

