package com.tarif.dsa.bitmanupulation2;

//			Problem Description
//			Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.
//			
//			Since the answer can be large, return the remainder after the dividing the answer by 109+7.
//			
//			
//			
//			Problem Constraints
//			1 <= N <= 105
//			
//			1 <= A[i] < 109
//			
//			
//			
//			Input Format
//			Only argument A is an array of integers
//			
//			
//			
//			Output Format
//			Return an integer denoting the sum of xor of all pairs of number in the array.
//			
//			
//			
//			Example Input
//			Input 1:
//			A = [1, 2, 3]
//			Input 2:
//			A = [3, 4, 2]
//			
//			
//			Example Output
//			Output 1:
//			6
//			Output 2:
//			14
//			
//			
//			Example Explanation
//			For Input 1:
//			Pair    Xor
//			{1, 2}  3
//			{1, 3}  2
//			{2, 3}  1
//			Sum of xor of all pairs = 3 + 2 + 1 = 6.
//			For Input 2:
//			Pair    Xor
//			{3, 4}  7
//			{3, 2}  1
//			{4, 2}  6
//			Sum of xor of all pairs = 7 + 1 + 6 = 14.




/**
 * 
 * @author Tarif M
 *
 */
public class SumOfXORofAllPairs {
	/**
	 * 
	 * @Idea
	 * If there are X elements with the i-th bit set and
	 * Y elements with i-th bit unset, then the number of xor
	 * pair where the i-th bit will be set is X*Y
	 */
	public int solve(int[] A) {
		final long MOD = 1000000007;
		long ans = 0;
		for(int j=0; j<32; j++) {
			long nomOfSetBitsAtIthPlace = 0;
			long nomOfUnSetBitsAtIthPlace = 0;
			for(int i=0; i<A.length; i++) {
				if((A[i]&(1<<j))>0) {
					nomOfSetBitsAtIthPlace++;
				}else {
					nomOfUnSetBitsAtIthPlace++;
				}
			}
			long nomOfSetBitsAtIthPlaceinXOR = nomOfSetBitsAtIthPlace*nomOfUnSetBitsAtIthPlace;
			ans = (ans + ((nomOfSetBitsAtIthPlaceinXOR%MOD) * (((long)Math.pow(2, j))%MOD))%MOD)%MOD;
			//ans = ans + nomOfSetBitsAtIthPlaceinXOR* Math.pow(2,j)
		}
		return (int)ans;
    }
	
	public static void main(String[] args) {
		int[] A = {3, 4, 2};
		SumOfXORofAllPairs sumXorP = new SumOfXORofAllPairs();
		System.out.println(sumXorP.solve(A));
	}

}
