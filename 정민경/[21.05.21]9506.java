package ARGOS;

import java.util.Scanner;

public class Perfect_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			int count = 0;
			int result = 0;
			int N = sc.nextInt();
			if(N == -1) {
				break;
			}
			
			int[] sum = new int[N];
			for(int i = 1; i < N; i++) {
				if(N % i == 0) {
					count = count + 1;
					sum[count] = i;
					result = result + i;
				}
			}
				
			if(result != N) {
				System.out.println(N + " is NOT perfect.");
				continue;
			}
			
			System.out.printf("%d = ",N);
			for(int j = 0; j < count; j++) {
				System.out.print(sum[j + 1]);
				if(j + 1 != count) {
					System.out.print(" + ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
