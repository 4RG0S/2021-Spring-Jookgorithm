package ARGOS;

import java.util.Scanner;

public class Fibbo_rec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Rec rec = new Rec(N);
		rec.print();
		
		sc.close();

	}

}
class Rec {
	int n1 = 0;
	int n2 = 1;;
	int num;
	
	Rec(int num){
		this.num = num;
	}
	int fibbo(int num) {
		if (num == 0) {
			return 0;
		}
		else if (num == 1) {
			return 1;
		}
		else {
			return fibbo(num - 1) + fibbo(num - 2);
		}
	}
	void print() {
		System.out.println(fibbo(num));
	}
}
