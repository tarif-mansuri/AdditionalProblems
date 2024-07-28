package com.tarif.day063.dsa.dp1.onediamentional;

public class MaxProductSubArray {
	
	public int maxProduct(final int[] A) {
		int max = Integer.MIN_VALUE;
		int curr = 1;
		for(int i=0; i<A.length; i++) {
			curr = curr*A[i];
			if(curr>max) {
				max = curr;
			}
			if(curr==0) {
				curr=1;
			}
		}
		curr = 1;
		for(int i=A.length-1; i>=0; i--) {
			curr = curr*A[i];
			if(curr>max) {
				max = curr;
			}
			if(curr==0) {
				curr=1;
			}
		}
		return max;
    }
	
	public static void main(String[] args) {
		MaxProductSubArray obj = new MaxProductSubArray();
		int[] A= {4, 2, -5, 1};
		System.out.println(obj.maxProduct(A));
	}

}
