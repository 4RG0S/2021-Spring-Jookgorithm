package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class jumplog {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] answer = new int[count];
		for(int i = 0; i < count; i++) {
			int num = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int numbers[] = new int[num];
			for(int j = 0; j < num; j++) 
				numbers[j] = Integer.parseInt(input[j]);
			Arrays.sort(numbers);
			int diff1 = 0;
			int diff2 = 0;
			int preAnswer = numbers[num - 1] - numbers[num - 2] >= numbers[num - 1] - numbers[num - 3] ? 
							numbers[num - 1] - numbers[num - 2] : numbers[num - 1] - numbers[num - 3];
			for(int k = num - 4; k >= 0; k -= 2) {
				if(k == 0) {
					diff1 = numbers[k + 1] - numbers[k] >= numbers[k + 2] - numbers[k] ? 
							numbers[k + 1] - numbers[k] : numbers[k + 2] - numbers[k];
					preAnswer = preAnswer > diff1 ? preAnswer : diff1;
					break;
				}
				diff1 = numbers[k + 1] - numbers[k] >= numbers[k + 2] - numbers[k - 1] ? 
						numbers[k + 1] - numbers[k] : numbers[k + 2] - numbers[k - 1];
				diff2 = numbers[k + 2] - numbers[k] >= numbers[k + 1] - numbers[k - 1] ? 
						numbers[k + 2] - numbers[k] : numbers[k + 1] - numbers[k - 1];
				if(diff1 <= diff2) {
					preAnswer = preAnswer > diff1 ? preAnswer : diff1;
				} else {
					preAnswer = preAnswer > diff2 ? preAnswer : diff2;
				}
			}
			answer[i] = preAnswer;
		}
		for(int i = 0; i < count; i++) 
			System.out.println(answer[i]);
	}

}
