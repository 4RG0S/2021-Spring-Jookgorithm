import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            System.out.println(solve(br.readLine()));
        }
	}

private static String solve(String input) {
	StringBuilder result = new StringBuilder();
	Stack<Character> left = new Stack<>();
	Stack<Character> right = new Stack<>();

	char[] password = input.toCharArray();

	for (char ch : password) {
		switch (ch) {
			case '<':
				if (!left.isEmpty()) right.push(left.pop());
				break;
			case '>':
				if (!right.isEmpty()) left.push(right.pop());
				break;
			case '-':
				if (!left.isEmpty()) left.pop();
				break;
			default:
				left.push(ch);
		}
	}
	for (Character character : left) {
		result.append(character);
	}
	while(!right.isEmpty())
		result.append(right.pop());

	return result.toString();
	}
}