package com.tarif.day038.dsa.sorting1.countsortandmergesort;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
	public int solve(int[] A) {
		Arrays.sort(A);
		int min = Integer.MAX_VALUE;
		for(int i=1; i<A.length; i++) {
			if(A[i]-A[i-1]<min) {
				min = A[i]-A[i-1];
			}
		}
		return min;
	}

}
