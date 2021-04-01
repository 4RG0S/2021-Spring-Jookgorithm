import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] token = br.readLine().split(" ");

		LinkedList<Integer> list = new LinkedList<>();
		int N = Integer.parseInt(token[0]); // 사람 수
		int to_eleminate = Integer.parseInt(token[1]); // 제거될 순서 

		for(int i = 1; i <= N; i++){ //리스트에 입력
			list.add(i);
		}

		// 출력 부분
		System.out.print("<");

		while(!list.isEmpty()){
			for(int i = 0; i < to_eleminate; i++){
				if(i == to_eleminate -1){
					int temp = list.remove();
					if(list.size() == 0){
						System.out.print(temp);
					} else {
						System.out.print(temp + ", ");
					}
				} else {
					list.add(list.remove());
				}
			}
		}

		System.out.print(">");
	}
}