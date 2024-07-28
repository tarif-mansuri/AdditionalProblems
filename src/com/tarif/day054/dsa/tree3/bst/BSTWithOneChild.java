package com.tarif.day054.dsa.tree3.bst;

public class BSTWithOneChild {
	public String solve(int[] A) {
        for(int i=0; i<A.length-1; i++){
            int min = A[i]<A[i+1]? A[i] : A[i+1];
            int max = A[i]>A[i+1]? A[i] : A[i+1];
            for(int j=i+2; j<A.length; j++){
                if(A[j]<min || A[j]>max){
                    return "NO";
                }
            }
        }
        return "YES";
    }
	public static void main(String[] args) {
		BSTWithOneChild obj = new BSTWithOneChild();
		int[] A = {12,1,9,6,2};
		System.out.println(obj.solve(A));
	}
}
