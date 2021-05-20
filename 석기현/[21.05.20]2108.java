package ClubHomework;

import java.util.Scanner;

public class GiHyeon2108 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] numbers = new int[8001];
		
		int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int middle = 10000;
		int something = middle;
		
		int i, temp;
		for(i = 0; i < num; i++) {
			temp = sc.nextInt();
			sum = sum + temp;
			numbers[temp + 4000]++;
		
			if(max < temp) {
				max = temp;
			}
			
			if(min > temp) {
				min = temp;
			}
		}
		

		int count = 0, realmax = 0;
		boolean realcount = false;	 
		
		for(i = min + 4000; i < max + 4000 + 1; i++) {
			
			if(numbers[i] > 0) {
				
				if(realmax < numbers[i]) {
					realmax = numbers[i];
					something = i - 4000;
					realcount = true;
				} else if(realmax == numbers[i] && realcount == true) {
					something = i - 4000;
					realcount = false;					
				}
				
				if(count < (num + 1) / 2) {
					count = count + numbers[i];	
					middle = i - 4000;
				}
				
			}
		}
		
		int print = (int) Math.round((double)sum / num);
		System.out.println(print); 
		System.out.println(middle);	 
		System.out.println(something);	
		System.out.println(max - min);
	}
 
}