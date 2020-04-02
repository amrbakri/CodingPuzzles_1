package com.example;

public class Main {

	public static void main(String[] args) {
		
//		func();
//		func_2();
        vacatedMidSecTrig();
	}

	private static void vacatedMidSecTrig() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i <= 4; i++) {
			for (int s1 = 0; s1 <= i-1; s1++) {
				if (s1 == 0)
					System.out.print(" ");
				else 
					System.out.print("  ");
			}
			
			for (int j = i; j <= 8-i; j++) {
				
				if (j == 0) System.out.print("*");
				else if (j != 4) System.out.print(" *");
				else if (i % 2 != 0) System.out.print("  ");
				else System.out.print(" *");
			}
			
			for (int s2 = 8-i+1; s2 <= 8; s2++) {
				System.out.print("  ");
			}
			
			System.out.println();
		}
		
		for (int m = 0; m <= 4; m++) {
			if (m == 0)
				System.out.print(" ");
			else if (m < 4) 
				System.out.print("  ");
			else 
				System.out.print(" *");

		}
	}
	
	private static void func_2() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i <= 4; i++) {
		
			for (int s = 0; s <= 5-i-1; s++) {
				if (s == 0)
					System.out.print(" ");
				else 
					System.out.print("  ");
			}
			
			for (int j = 0; j <i+1; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		
		for (int k = 0; k <= 3; k++) {
			
			if (k == 0) 
				System.out.print("*");
			else 
				System.out.print(" *");
			
			if (k < 2) {
				for (int l = 0; l <= 0; l++) {
					System.out.print("  ");
				}
			}
			
		}
		
		
	}

	private static void func() {
		// TODO Auto-generated method stub
		int s = 0;
		int e = 0;
		for (int i = 0 ; i <= 4; i++) {
			
			for (s = 0; s < i; s++) {
				if (i > 0) {
					System.out.print("  ");
				}
			} 
			if (i%2 != 0) {
				e = 2;
			} else {
				e = 1;
			}
			for (int j = s; j <= (9-e)-i; j++) {
				
				if (i == 0) {
					System.out.print("* ");
				} else {
					if (j >= i) {
						System.out.print("* ");
					}
					if(j == 3 && i%2!=0) {
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		
		
		}
	}
}
