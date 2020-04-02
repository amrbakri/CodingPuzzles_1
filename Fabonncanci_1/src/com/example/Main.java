package com.example;

public class Main {
	public static void main(String[] args) {
		int res = fab_recursive_2(10);
		System.out.println(res);
	}
	
	private static int fab_recursive_2(int kth) {
		// TODO Auto-generated method stub

		if (kth == 0) {
			return 0;
		}
		if (kth == 1) {
			return fab_recursive_2(kth - 1) + 1;
		}
		return fab_recursive_2(kth-1) + fab_recursive_2(kth-2);
	}
}
