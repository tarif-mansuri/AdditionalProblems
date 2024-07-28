package com.tarif.day063.dsa.dp1.onediamentional;

public class MaximumSumValue {
	public int solve(int[] A, int B, int C, int D) {
		if(A.length==0) {
			return 0;
		}
		int n = A.length;
		int[] preMax = new int[A.length];
		preMax[0] = B*A[0];
		
		for(int i=1; i<A.length; i++) {
			preMax[i] = Math.max(preMax[i-1], B*A[i]);
		}
		int[] postMax = new int[A.length];
		postMax[n-1] = D*A[n-1];
		
		for(int i=n-2; i>=0; i--) {
			postMax[i] = Math.max(postMax[i+1], D*A[i]);
		}
		int ans = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, C*A[i]+postMax[i]+preMax[i]);
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 5, -3, 4, -2};
		MaximumSumValue maxSumValue = new MaximumSumValue();
		System.out.println(maxSumValue.solve(A, 2, 1, -1));
	}
}