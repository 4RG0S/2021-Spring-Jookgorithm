package ARGOS;

import java.util.Scanner;

public class Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int facN = 1;//N!
		int facK = 1;//K!
		int fac = 1;//(N-K)!
		
		for(int i = 1; i <= N; i++) { //N!구하기
			facN = facN * i;
		}
		for(int i = 1; i <= K; i++) { //K!구하기
			facK = facK * i;
		}
		for(int i = 1; i <= N - K; i++) { //(N - K)!구하기
			fac = fac * i;
		}
		System.out.println(facN / facK / fac);
		
		sc.close();
	}

}
