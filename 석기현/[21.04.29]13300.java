package ClubHomework;

import java.util.Scanner;

public class GiHyeon13300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int students = sc.nextInt();
		int rooms = sc.nextInt();

		int information[][] = new int[7][2];
		
		int i, gender;
		for(i = 0; i < students; i++) {
			gender = sc.nextInt();
			if(gender == 0) {
				information[sc.nextInt()][0]++;
			} else {
				information[sc.nextInt()][1]++;
				}
		}
		
		int roomnumbers = 0;
		for(i = 0; i < 7; i++) {
			if(information[i][1] == 0) {
				continue;
			} else if(information[i][1] <= rooms) {
				roomnumbers++;
			} else if(information[i][1] % rooms == 0) {
				roomnumbers = roomnumbers + information[i][1] / rooms;
			} else {
				roomnumbers = roomnumbers + information[i][1] / rooms;
				roomnumbers++;
			}	
		}
		
		for(i = 0; i < 7; i++) {
			if(information[i][0] == 0) {
				continue;
			} else if(information[i][0] <= rooms) {
				roomnumbers++;
			} else if(information[i][0] % rooms == 0) {
				roomnumbers = roomnumbers + information[i][0] / rooms;
			} else {
				roomnumbers = roomnumbers + information[i][0] / rooms;
				roomnumbers++;
			}
		}
		
		System.out.printf("%d", roomnumbers);

	}

}
