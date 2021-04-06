package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class othelloreplace {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] answer = new int[count];
		for(int i = 0; i < count; i++) {
			Integer.parseInt(br.readLine());
			int num = 0;
			int[] white = new int[2];
			String[] first = br.readLine().split("");
			String[] goal = br.readLine().split("");
			for(int j = 0; j < first.length; j++) {
				if(first[j].equals("W")) 
					white[0]++;
				if(goal[j].equals("W")) 
					white[1]++;
			}
			if(white[0] - white[1] >= 0) {
				int a = white[0] - white[1];
				for(int k = 0; k < first.length; k++) {
					if(!first[k].equals(goal[k]) && first[k].equals("W") && a > 0) {
						first[k] = "B";
						answer[i]++;
						a--;
					} else if(!first[k].equals(goal[k])) {
						num++;
					}
				}
			} else if(white[1] - white[0] > 0) {
				int a = white[1] - white[0];
				for(int k = 0; k < first.length; k++) {
					if(!first[k].equals(goal[k]) && first[k].equals("B") && a > 0) {
						first[k] = "W";
						answer[i]++;
						a--;
					} else if(!first[k].equals(goal[k])) {
						num++;
					}
				}
			}
			answer[i] += num / 2;
		}
		
		for(int i = 0; i < answer.length; i++) 
			System.out.println(answer[i]);

	}

}
