package ClubHomework;

import java.util.Scanner;

public class GiHyeon1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int minnum = sc.nextInt();
		int maxnum = sc.nextInt();
		
		boolean checker[] = new boolean[maxnum + 1];
		checker[0] = checker[1] = true; // 초깃값 설정하고
		
		int i, j;
		for(i = 2; i < maxnum + 1; i++) {
			if(checker[i] == true) {
				continue;
			}
			
			for(j = 2 * i; j < maxnum + 1 ; j= j + i) {
				checker[j] = true;
			}
		} // false이면 소수이고 true면 소수아님!
		
		for(i = minnum; i < maxnum + 1; i++) {
			if(checker[i] == false) {
				System.out.println(i);
			}
		} // 끗
	}

}
