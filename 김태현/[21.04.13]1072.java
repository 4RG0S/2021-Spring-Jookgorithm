package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class hyeongtaekgame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		long[] b = new long[2];
		b[0] = Long.parseLong(a[0]);
		b[1] = Long.parseLong(a[1]);
		if(b[0] == b[1]) {
			System.out.println(-1);
			return;
		}
		long A = (long)((double)b[1] * 100 / b[0]);
		if(A == 99) {
			System.out.println(-1);
			return;
		}
		long answer = (long)Math.ceil((double)(100 * b[1] - b[0] * (A + 1)) / (A - 99));
		System.out.println(answer);
	}

}
