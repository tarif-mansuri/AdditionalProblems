package com.tarif.day059.dsa.heap1.introduction;

import java.util.PriorityQueue;

public class MishaAndCandies {
	public int solve(int[] A, int B) {
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<A.length; i++) {
			pq.add(A[i]);
		}
		while(pq.size()>0 && pq.peek()<=B) {
			int min = pq.poll();
			sum+=min/2;
			if(pq.size()>0) {
				int min2 = pq.poll();
				min2 +=min-min/2;
				pq.add(min2);
			}
		}
		return sum;
    }
	
	public static void main(String[] args) {
		MishaAndCandies obj = new MishaAndCandies();
		int[] A = {4,3,5,6};
		System.out.println(obj.solve(A, 7));
	}
}
