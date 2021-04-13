import java.util.*;

// 백준 9012
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = Integer.parseInt(sc.nextLine());

		for(int i = 0; i < rows; i++){
			String token = sc.nextLine();
			System.out.println(solve(token));
		}
		sc.close();
	}

	private static String solve(String token){

		Stack<Character> stack = new Stack<>(); // "(" 저장할 스택

		for(int j = 0; j < token.length(); j++){
			if(token.charAt(j) == '('){
				stack.push(token.charAt(j));
			} else if(stack.isEmpty()){
				return "NO";
			} else {
				stack.pop();
			}
		}
		
		if(stack.isEmpty())
			return "YES";
		else 
			return "NO";
	}
}