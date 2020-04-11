package com.example;

import java.lang.reflect.Array;

public class Main {

	public static void main(String[] args) {
		int []x = new int[] {0, 32, 43, 54, 56, 57, 88, 99, 100, 100, 5, 3, 2, 1, 1, 1, 1};
		int []x1 = new int[] {0, 32, 43, 54, 56, 57, 88, 99, 100, 100, 5, 3, 2, 1, 1, 1, 1, 22, 33, 44, 55};
		int []x2 = new int[] {1, 1, 1, 1, 1};
		int []x3 = new int[] {14};
		
		topPeaks(x, -1, new int[x1.length], -1, new int[x1.length], -1, new int[x1.length], -1, 0);	
		}

	private static void topPeaks(int[] x, int i, int[] ascendedSlopeTerritor, int idx1, int[] descendedSlopeTerritor, int idx2, int[] flatSurface, int idx3, int strterIdx) {
		// TODO Auto-generated method stub
		
		int maxIdx = x.length - 1;
		
		if (maxIdx < 0 || ++i < 0) {
			System.out.println("SURFACE_DOES_NOT_EXIST");
			return;
		}
		
		//STOPPING-CONDITION
		if (maxIdx == i) {
		//unclassifiedTerritor[++unclassifiedTerritorIdx] = i;
		//MERGER_FUNC
			if (maxIdx == 0) System.out.println("Unclassified single point at index = " + i + " ELEV = " + x[i]);
			
			else if (maxIdx == 1) {
				if (x[maxIdx - 1] > x[maxIdx])
					System.out.println("Terminator point on the descending surafce at index = " + i + " ELEV = " + x[i]);
				
				else if (x[maxIdx - 1] < x[maxIdx])
					System.out.println("Terminator point on the asescending surafce at index = " + i + " ELEV = " + x[i]);
				
				else if (x[maxIdx - 1] == x[maxIdx])
					System.out.println("Terminator point on the flate surafce at index = " + i + " ELEV = " + x[i]);
			}
			
			else {
				if (x[maxIdx -2] < x[maxIdx - 1]) {
					if (x[maxIdx - 1] < x[maxIdx]) {
						System.out.println("Terminator point as ascending-consummation/continuation/pursuance point on ascending surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);						
					}
					
					if (x[maxIdx - 1] > x[maxIdx]) {
						System.out.println("Terminator point as descnding-Divergence-Routing point on ascending surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);		
					}
					
					if (x[maxIdx - 1] == x[maxIdx]) {
						System.out.println("Terminator point as flat-Divergence-Routing point on ascending surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);		
					}
				}
				
				if (x[maxIdx -2] > x[maxIdx - 1]) {
					if (x[maxIdx - 1] < x[maxIdx]) {
						System.out.println("Terminator point as aescnding-Divergence-Routing point on descending surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);						
					}
					
					if (x[maxIdx - 1] > x[maxIdx]) {
						System.out.println("Terminator point as descending-consummation/continuation/pursuance point on descending surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);		

					}
					
					if (x[maxIdx - 1] == x[maxIdx]) {
						System.out.println("Terminator point as flat-Divergence-Routing point on descending surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);		
					}
				}
				
				if (x[maxIdx -2] == x[maxIdx -1]) {
					if (x[maxIdx - 1] < x[maxIdx]) {
						System.out.println("Terminator point as ascending-Divergence-Routing point point on flat-surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);						
					}
					
					if (x[maxIdx - 1] > x[maxIdx]) {
						System.out.println("Terminator point as descending-Divergence-Routing point on flat-surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);		

					}
					
					if (x[maxIdx - 1] == x[maxIdx]) {
						System.out.println("Terminator point as flat-consummation/continuation/pursuance on flat-surafce at index = " + maxIdx + " ELEV = " + x[maxIdx]);		
					}
				}
			}
			return;
		}
				
		if (i == strterIdx) {
			
			//#Ascending/upgraded-slope
			if (x[i] < x[i + 1]) {
				System.out.println("Lev: " +  (i) + " Initial point on ascending slope at Index: " + i + " ELEV = " + x[i]);
				ascendedSlopeTerritor[++idx1] = i;
			}
			
			//#Descending/downgraded-slope
			else if (x[i] > x[i + 1]) {
				System.out.println("Lev: " +  (i) + " Initial point on descending slope at Index: " + i + " ELEV = " + x[i]);	
				descendedSlopeTerritor[++idx2] = i;
			}
			
			//#Flat-slope
			else if (x[i] == x[i + 1]) {
				System.out.println("Lev: " +  (i) + " Initial point on flate slope at Index: " + i + " ELEV = " + x[i]);	
				flatSurface[++idx3] = i;
			}
			
			System.out.println("->RECUR. ITER TO BE EXECUTED<-");	
			//topPeaks(x, i, ascendedSlopeTerritor, descendedSlopeTerritor, flatSurface, strterIdx);
			topPeaks(x, i, ascendedSlopeTerritor, idx1, descendedSlopeTerritor, idx2,flatSurface, idx3,strterIdx);
			return;
		}
		
		//#Continuation
		//#Ascending/upgraded-slope
		if (x[i - 1] < x[i] && x[i] < x[i + 1] ) {
			System.out.println("Lev: " +  (i) + " Consummation point on ascending slope at Index: " + i + " ELEV = " + x[i]);	
			ascendedSlopeTerritor[++idx1] = i;
			System.out.println("->RECUR. ITER TO BE EXECUTED<-");	
			//topPeaks(x, i, ascendedSlopeTerritor, descendedSlopeTerritor, flatSurface, strterIdx);
			topPeaks(x, i, ascendedSlopeTerritor, idx1, descendedSlopeTerritor, idx2,flatSurface, idx3,strterIdx);
			return;
		}
		
		//#Descending/downgraded-slope
		else if (x[i - 1] > x[i] && x[i] > x[i + 1] ) {
			System.out.println("Lev: " +  (i) + " Consummation point on descending slope at Index: " + i + " ELEV = " + x[i]);
			descendedSlopeTerritor[++idx2] = i;
			System.out.println("->RECUR. ITER TO BE EXECUTED<-");	
			//topPeaks(x, i, ascendedSlopeTerritor, descendedSlopeTerritor, flatSurface, strterIdx);
			topPeaks(x, i, ascendedSlopeTerritor, idx1, descendedSlopeTerritor, idx2,flatSurface, idx3,strterIdx);
			return;
		}
		
		//#Flat-slope
		else if (x[i - 1] == x[i] && x[i] == x[i + 1] ) {
			System.out.println("Lev: " +  (i) + " Consummation point on flate-surafce slope at Index: " + i + " ELEV = " + x[i]);
			flatSurface[++idx3] = i;
			System.out.println("->RECUR. ITER TO BE EXECUTED<-");	
			//topPeaks(x, i, ascendedSlopeTerritor, descendedSlopeTerritor, flatSurface, strterIdx);
			topPeaks(x, i, ascendedSlopeTerritor, idx1, descendedSlopeTerritor, idx2,flatSurface, idx3,strterIdx);
			return;
		}
		
		//#Divergence-Routing
		//#Ascending/upgraded-slope
		if (x[i - 1] < x[i] && x[i] > x[i + 1] ||
			x[i - 1] < x[i] && x[i] == x[i + 1]) {
			ascendedSlopeTerritor[++idx1] = i;
			System.out.println("Lev: " +  (i) + " Consummation AND Divergence point on ascending slope at Index: " + i + " ELEV = " + x[i]);	
			System.out.println("SEG/PARCEL-DETECTED");
			System.out.println();
			topPeaks(x, i, new int[x.length - i + 2], -1, new int [x.length - i + 2], -1, new int[x.length- i + 2], -1, (i + 1));
			return;
		}
		
		//#Descending/downgraded-slope
		else if (x[i - 1] > x[i] && x[i] < x[i + 1] ||
				 x[i - 1] > x[i] && x[i] == x[i + 1]) {
			descendedSlopeTerritor[++idx2] = i;
			System.out.println("Lev: " +  (i) + " Consummation AND Divergence point on descending slope at Index: " + i + " ELEV = " + x[i]);
			System.out.println("SEG/PARCEL-DETECTED");
			System.out.println();
			topPeaks(x, i, new int[x.length - i + 2], -1, new int [x.length - i + 2], -1, new int[x.length- i + 2], -1, (i + 1));
			return;
		}
		
		//#Flat-slope
		else if (x[i - 1] == x[i] && x[i] < x[i + 1] ||
				x[i - 1] == x[i] && x[i] > x[i + 1]) {
			flatSurface[++idx3] = i;
			System.out.println("Lev: " +  (i) + " Consummation AND Divergence point on flate-surafce slope at Index: " + i + " ELEV = " + x[i]);	
			System.out.println("SEG/PARCEL-DETECTED");
			System.out.println();
			topPeaks(x, i, new int[x.length - i + 2], -1, new int [x.length - i + 2], -1, new int[x.length- i + 2], -1, (i + 1));
			return;
		}
	}
}
