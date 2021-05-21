package ARGOS;

import java.util.Scanner;
import java.util.Arrays;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //시험 본 과목의 개수
		double[] score = new double[N]; 
		
		for(int i = 0; i < N; i++) {
			score[i] = sc.nextDouble();
		}
		
		double sum = 0;
		Arrays.sort(score);
		
		for(int i = 0; i < N; i++) {
			sum += ((score[i]/score[N-1])*100);
		}
		
		System.out.print(sum / N);
		
		sc.close();
	}

}
