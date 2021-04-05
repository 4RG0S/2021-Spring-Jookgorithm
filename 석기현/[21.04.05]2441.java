package ClubHomework;

import java.util.Scanner;

public class GiHyeon2441 {

	public static void main(String[] args) {
		
		        Scanner sc = new Scanner(System.in);
		        int num = sc.nextInt();
		        
		        int i, j, k;
		        for(i = 0; i < num; i++) { 
		            for(j = num - i; j < num; j++) {
		                System.out.print(" ");      
		            }         
		            for(k = i; k < num; k++) {
		                System.out.print("*");   
		            }             
		            System.out.println();            
		        }
		    
		}
}
