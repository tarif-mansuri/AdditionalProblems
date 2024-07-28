package com.tarif.day059.dsa.heap1.introduction;

import java.util.PriorityQueue;

public class MaxArraySumAfterBNegation {
	public int solve(int[] A, int B) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<A.length; i++) {
			pq.add(A[i]);
		}
		for(int i=0; i<B; i++) {
			int min = -pq.poll();
			pq.add(min);
		}
		int ans = 0;
		while(pq.size()>0) {
			ans +=pq.poll();
		}
		return ans;
    }
	public static void main(String[] args) {
		int[] A = {57, 3, -14, -87, 42, 38, 31, -7, -28, -61};
		MaxArraySumAfterBNegation obj = new MaxArraySumAfterBNegation();
		System.out.println(obj.solve(A, 10));
	}
}
