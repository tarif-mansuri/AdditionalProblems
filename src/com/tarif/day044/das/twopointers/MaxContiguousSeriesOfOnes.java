package com.tarif.day044.das.twopointers;

public class MaxContiguousSeriesOfOnes {
	
	public int[] maxone(int[] A, int B) {
		int p1, p2;
		p1 = p2 = 0;
		int maxLen = -1;
		int countZ = 0;
		while(p2<A.length) {
			if(A[p2] == 0) {
				countZ++;
				p2++;
			}
			if(countZ>B) {
				
			}
		}
    }

}
