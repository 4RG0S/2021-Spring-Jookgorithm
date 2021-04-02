package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class rope {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ropeSet = new int[n];
		for(int i = 0; i < n; i++) {
			ropeSet[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ropeSet);
		int value = ropeSet[0] * n;
		for(int i = 1; i < n; i++) {
			value = value > ropeSet[i] * (n - i) ? value : ropeSet[i] * (n - i); 
		}
		System.out.println(value);
	}

}
