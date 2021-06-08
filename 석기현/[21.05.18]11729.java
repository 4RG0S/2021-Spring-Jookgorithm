package ClubHomework;

import java.util.Scanner;

public class GiHyeon11729 {
 
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
 
		sb.append((int) (Math.pow(2, num) - 1)).append('\n');
 
		Hanoi(num, 1, 2, 3);
		System.out.println(sb);	
		
	}
		static void Hanoi(int num, int first, int mid, int to) {

			if (num == 1) {
				sb.append(first + " " + to + "\n");
				return;
			}
			
			Hanoi(num - 1, first, to, mid);
			sb.append(first + " " + to + "\n");
			Hanoi(num - 1, mid, first, to);
			
		}
}