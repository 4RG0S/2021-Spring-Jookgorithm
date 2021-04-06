package baekjoon;

import java.util.Scanner;
import java.util.ArrayList;

public class permutationorder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final long[] F = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 
						  87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 
						  121645100408832000L, 2432902008176640000L};
		int N = scanner.nextInt();
		scanner.nextLine();
		ArrayList<Integer> seq = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) 
			seq.add(i);
		int o = scanner.nextInt();
		long o1 = 0;
		int[] o2 = new int[N];
		if(o == 1) 
			o1 = scanner.nextLong();
		else 
			for(int i = 0; i < N; i++) 
				o2[i] = scanner.nextInt();
		scanner.close();
		if(o == 1) {
			int count = N - 1;
			while(count != 0) {
				int a = 0;
				while(o1 - F[count] > 0) {
					o1 -= F[count];
					a++;
				}
				count--;
				System.out.print(seq.get(a) + " ");
				seq.remove(a);
			}
			System.out.print(seq.get(0));
		}
		if(o == 2) {
			long answer = 0;
			for(int i = 0; i < N; i++) {
				answer += F[N - i - 1] * seq.indexOf(o2[i]);
				seq.remove((Integer)(o2[i]));
			}
			answer += 1;
			System.out.println(answer);
		}
	}

}
