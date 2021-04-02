package baekjoon;

import java.util.Scanner;

public class numbersquare {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int row_value = scanner.nextInt();
		int column_value = scanner.nextInt();
		scanner.nextLine();
		
		String[] value = new String[row_value];
		
		for(var i = 0; i < value.length; i++) {
			value[i] = scanner.nextLine();
		}
		
		scanner.close();
		
		int area = 1;
		
		for(int i = 0; i < row_value; i++) {
			for(int j = 0; j < column_value; j++) {
				char character = value[i].charAt(j);
				
				for(int k = 1; k < column_value - j; k++) {
					
					if(character == value[i].charAt(j + k)) {
						if(i + k <= row_value - 1) {
							if(character == value[i + k].charAt(j) && value[i + k].charAt(j) == value[i + k].charAt(j + k)) {
								area = (k + 1) * (k + 1) > area ? (k + 1) * (k + 1) : area;
							}
						}
					}
				}
			}
		}
		
		System.out.println(area);
		
	}

}
