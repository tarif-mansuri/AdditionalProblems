package com.tarif.day060.dsa.heap2.problems;

import java.util.PriorityQueue;

public class KthSmallestInMat {
	public int solve(int[][] A, int B) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> b-a);
		for(int i = 0; i<A.length; i++) {
			for(int j=0; j<A[i].length; j++) {
				if(pq.size()<B) {
					pq.add(A[i][j]);
				}else {
					if(A[i][j]<pq.peek()) {
						pq.poll();
						pq.add(A[i][j]);
					}
				}
			}
		}
		
		return pq.peek();
    }
	
	public static void main(String[] args) {
		KthSmallestInMat obj = new KthSmallestInMat();
		int[][] A = {{9,11,15},{10,15,17}};
		System.out.println(obj.solve(A, 5));
	}
}
