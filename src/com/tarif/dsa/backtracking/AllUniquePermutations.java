package com.tarif.dsa.backtracking;

import java.util.ArrayList;

//	Problem Description
//	Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
//	
//	NOTE: No 2 entries in the permutation sequence should be the same.
//	
//	
//	
//	Problem Constraints
//	1 <= |A| <= 9
//	
//	0 <= A[i] <= 10
//	
//	
//	
//	Input Format
//	Only argument is an integer array A of size N.
//	
//	
//	
//	Output Format
//	Return a 2-D array denoting all possible unique permutation of the array.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	A = [1, 1, 2]
//	Input 2:
//	
//	A = [1, 2]
//	
//	
//	Example Output
//	Output 1:
//	
//	[ [1,1,2]
//	  [1,2,1]
//	  [2,1,1] ]
//	Output 2:
//	
//	[ [1, 2]
//	  [2, 1] ]
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 All the possible unique permutation of array [1, 1, 2].
//	Explanation 2:
//	
//	 All the possible unique permutation of array [1, 2].
//	
//	
//	
//	Expected Output
//	Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases


public class AllUniquePermutations {
	private static int index=0;
    public  int[][] permute(int[] A) {
        int size = getFact(A.length);
        index = 0;
        
        int[] hash = new int[11];
        for(int i=0; i<A.length; i++) {
            hash[A[i]]++;
        }
        for(int i=0; i<hash.length; i++) {
            if(hash[i]>1) {
                size /=getFact(hash[i]);
            }
        }
        //System.out.print(size);
        int[][] ans = new int[size][A.length];
        permuteUtil(A, hash, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    public  void permuteUtil(int[] A, int[] hash, int ind, ArrayList<Integer> current, int[][] ans) {
        if(ind==A.length) {
            for(int i=0; i<current.size(); i++) {
                ans[index][i] = current.get(i);
            }
            index++;
        }
        for(int i=0; i<hash.length; i++) {
            if(hash[i]>0) {
                hash[i]--;
                current.add(i);
                permuteUtil(A, hash, ind+1, current, ans);
                hash[i]++;
                current.remove(current.size()-1);
            }
        }
    }
    public static int getFact(int A) {
        int fact = 1;
        for(int i=1; i<=A; i++) {
            fact *=i;
        }
        return fact;
    }
    
    public static void main(String[] args) {
    	AllUniquePermutations aup = new AllUniquePermutations();
    	int[] A = {1,1,2,3};
    	aup.permute(A);
    }

}
