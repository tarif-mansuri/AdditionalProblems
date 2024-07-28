package com.tarif.day059.dsa.heap1.introduction;

import java.util.PriorityQueue;

public class MinimumLargestElement {
	public int solve(int[] A, int B) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->a.nextState-b.nextState);
		int[] copy = new int[A.length];
		for(int i=0; i<A.length; i++) {
			pq.add(new Pair(2*A[i],i));
			copy[i] = A[i];
		}
		while(B-->0) {
			Pair min = pq.poll();
			copy[min.ind] = copy[min.ind]+A[min.ind];
			pq.add(new Pair(min.nextState+A[min.ind], min.ind));
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<copy.length;i++) {
			if(copy[i]>max) {
				max = copy[i];
			}
		}
		return max;
    }
	
	public static void main(String[] args) {
		MinimumLargestElement mle = new MinimumLargestElement();
		int[] A = {5,7,8};
		System.out.println(mle.solve(A, 9));
	}

}
class Pair{
	int nextState;
	int ind;
	Pair(int nextState, int ind){
		this.nextState = nextState;
		this.ind = ind;
	}
}
