package com.tarif.day049.dsa.stack2.nearestsmallergreater;

import java.util.Stack;

public class SortStackUsingStacks {
	public int[] solve(int[] A) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for(int i=A.length-1; i>=0; i--) {
			while(!s1.isEmpty() && s1.peek()<A[i]) {
				s2.push(s1.pop());
			}
			s1.push(A[i]);
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		int i=0;
		while(!s1.isEmpty()) {
			A[i++] = s1.pop();
		}
		return A;
    }
	
	public static void main(String[] args) {
		SortStackUsingStacks obj = new SortStackUsingStacks();
		int[] A = {5, 17, 100, 11};
		obj.solve(A);
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}

}
