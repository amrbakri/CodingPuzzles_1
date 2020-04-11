package com.example;

public class Main {

	public static void main(String[] args) {
		int []x = new int[] {0, 32, 43, 54, 56, 57, 88, 99, 100, 100, 5, 3, 2, 1, 1, 1, 1};
		int []x1 = new int[] {0, 32, 43, 54, 56, 57, 88, 99, 100, 100, 5, 3, 2, 1, 1, 1, 1, 22, 33, 44, 55};
		int []x2 = new int[] {1, 1, 1, 1, 1};

		topPeaks(x2);	
		}

	private static int[] topPeaks(int[] x) {
		// TODO Auto-generated method stub
		
		int len = x.length;
		boolean _mode2ScanForBaseOfAPeak = false;
		boolean _mode1ScanForPeakOfABase = false;
		int topPeak = -1;
		int [] topPeaks = new int[len];
		int topPeaksIdx  = -1;
		int baseOfAPeak = -1;
		int [] basesOfPeaks = new int[len];
		int basesOfPeaksIdx = -1;
		
		int lowestBase = -1;
		int [] lowestBases  = new int[len];
		int lowestBasesIdx  = -1;
		int peakOfALowestBase = -1;
		int [] peaksOfBases = new int[len];
		int peaksOfBasesIdx = -1;
		
		int[] flatsurfaces = new int[len];
		int flatSurfacesIdx = -1;
		
		if (len == 0) 
			return new int[] {-2};
		if (len == 1) 
			return new int[] {-1};
		
		for (int i = 0; i < len; i++) {
			
			if (_mode1ScanForPeakOfABase) {
				if (i == len - 1) {
					peakOfALowestBase = i;
					System.out.println("peakOfALowestBase @index: " + i + " of ELEV = " + x[i] + ". Terminal/Final point on the surface, no farther "
							+ "points could be explored.");
					peaksOfBases[++basesOfPeaksIdx] = i;
					_mode1ScanForPeakOfABase = false;
					continue;
				}
				
				if (x[i] == x[i + 1]) {
					peakOfALowestBase = i;
					System.out.println("peakOfALowestBase @index: " + i + " of ELEV = " + x[i] + ". Follwoed by a flatSurface(s).");
					peaksOfBases[++basesOfPeaksIdx] = i;
					_mode1ScanForPeakOfABase = false;
					continue;
				}
				
				if (x[i] > x[i + 1]) {
					peakOfALowestBase = i;
					System.out.println("peakOfALowestBase @index: " + i + " of ELEV = " + x[i] + ". Follwoed by an unexplored point on the surafce of an ELEV "
							+ "lower than the current one.");
					peaksOfBases[++basesOfPeaksIdx] = i;
					_mode1ScanForPeakOfABase = false;
					continue;
				}
				
				continue;
			}
			
			if (_mode2ScanForBaseOfAPeak) {
				if (i == len - 1) {
					baseOfAPeak = i;
					System.out.println("BaseOfATopPeak @index: " + i + " of ELEV = " + x[i] + ". Terminal/Final point on the surface, no farther "
							+ "points could be explored.");
					basesOfPeaks[++basesOfPeaksIdx] = i;
					_mode2ScanForBaseOfAPeak = false;
					continue;
				}
				
				if (x[i] == x[i + 1]) {
					baseOfAPeak = i;
					System.out.println("BaseOfATopPeak @index: " + i + " of ELEV = " + x[i] + ". Follwoed by a flatSurface(s).");
					basesOfPeaks[++basesOfPeaksIdx] = i;
					_mode2ScanForBaseOfAPeak = false;
					continue;
				}
				
				if (x[i] < x[i + 1]) {
					baseOfAPeak = i;
					System.out.println("BaseOfATopPeak @index: " + i + " of ELEV = " + x[i] + ". Follwoed by an unexplored point on the surafce of an ELEV "
							+ "lower than the current one.");
					basesOfPeaks[++basesOfPeaksIdx] = i;
					_mode2ScanForBaseOfAPeak = false;
					continue;
				}
				continue;
			}
			
			if (i == len - 1) {
				if (x[i] == x[i - 1]) {
					System.out.println("Final site on the surface reached/explored. @index: " + i + " of ELEV = " + x[i] + ". Relatively, it is considered as a continuation to the faltsurface.");
				}
				
				if (x[i] > x[i - 1]) {
					System.out.println("Final site on the surface reached/explored. @index: " + i + " of ELEV = " + x[i] + ". Relatively, it is considered as peak to the previous point.");
				}

				if (x[i] < x[i - 1]) {
					System.out.println("Final site on the surface reached/explored. @index: " + i + " of ELEV = " + x[i] + " . Relatively, it is considered as base to the previous point.");
				}
				continue;
			}
			
			//in case of occurrence of of bugs, add cnt keyword in each if-statement 
			if (x[i] < x[i + 1]) {
				lowestBase = i;
				System.out.println("LowestBase @index: " + i + " of ELEV = " + x[i]);
				lowestBases[++lowestBasesIdx] = i;
				_mode1ScanForPeakOfABase = true;
			}
			
			if (x[i] > x[i + 1]) {
				topPeak = i;
				System.out.println("TopPeak @index: " + i + " of ELEV = " + x[i]);
				topPeaks[++topPeaksIdx] = i;
				_mode2ScanForBaseOfAPeak = true;
			}
			
			if (x[i] == x[i + 1]) {
				flatsurfaces[++flatSurfacesIdx] = i;
				System.out.println("Flatsurfaces @index: " + i + " of ELEV = " + x[i]);
			}
			
			continue;
		}
		return peaksOfBases;
	}
}
