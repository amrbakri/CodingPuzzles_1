package com.example;

public class Main {

	public static void main(String[] args) {
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
}
