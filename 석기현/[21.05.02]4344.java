package ClubHomework;

import java.util.Scanner;

public class GiHyeon4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// 05.01) 굳이 케이스 수 대로 배열을 만들어야 하나?
		// 오늘) 케이스 수 대로 배열 개수를 생성하는 것이 아니라 for문 내에서 배열의 초기화 이용
		
		int i, j;
		double sum, average, count;
		for(i = 0; i < num; i++) {
			
			int students = sc.nextInt();
			int score[] = new int[students];
			
			sum = 0;
			
			for(j = 0; j < students; j++) {
				score[j] = sc.nextInt();
				sum = score[j] + sum;
			}
			
			count = 0;
			average = sum / students;
			for(j = 0; j < students; j++) {
				if(score[j] > average) {
					count++;
				}
			}
			
			double last = (count / students) * 100.0; // Math.round() 함수는 소수 밑자리가 0일 경우 정수값을 반환한다.(주의)
			System.out.println(String.format("%.3f%%", last));
		}

	}

}
