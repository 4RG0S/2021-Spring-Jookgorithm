package ClubHomework;

import java.util.Scanner;
 
public class GiHyeon10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int N = sc.nextInt();
		int X = sc.nextInt();
		int a[] = new int[N];
        
        int i;
		for (i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
 
		sc.close();
        
		for ( i = 0; i < N; i++) {
			if (a[i] < X) {
				System.out.printf("%d ", a[i]);
			}
		}
	}
}