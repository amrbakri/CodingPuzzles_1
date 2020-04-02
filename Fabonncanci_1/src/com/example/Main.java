package com.example;

public class Main {

	static int idx = 0;
	static int len = 10;
	static int x[] = new int[len];
	
	static boolean inited = false;
	static int idx_2;
	static int len_2;
	static int x_2[] = null;
	
	public static void main(String[] args) {
//		for (int i = 0; i <= len; i++) {
//			fab();
//		}
//		System.out.println();

//		fab_recursive(9);
//		System.out.println();
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

	private static void fab_recursive(int n) {
		// TODO Auto-generated method stub
		
		
		if (!inited) {
			idx = 0;
			len = 10;
			x = new int[len];
			inited = true;
		}
		if (n == len) {
			return; 
		}
		if (idx == 0) {
			x[idx] = 0;
			System.out.print(" " + x[idx]);
			fab_recursive(++idx);
		}
		
		else if (idx-1 == 0) {
			x[idx] = x[idx - 1] + 1;
			System.out.print(", " + x[idx]);
			fab_recursive(++idx);
		}
		
		else if (idx-1 >= 1) {
			x[idx] = x[idx - 2] + x[idx - 1];
			System.out.print(", " + x[idx]);
			fab_recursive(++idx);
		}
	}

	public static void fab() {
		
		if (idx == len) {
			return; 
		}
		if (idx == 0) {
			x[idx] = 0;
			System.out.print(" " + x[idx]);
		}
		
		else if (idx-1 == 0) {
			x[idx] = x[idx - 1] + 1;
			System.out.print(", " + x[idx]);
		}
		
		else if (idx-1 >= 1) {
			x[idx] = x[idx - 2] + x[idx - 1];
			System.out.print(", " + x[idx]);
		}
		
		++idx;
		
	}
}
