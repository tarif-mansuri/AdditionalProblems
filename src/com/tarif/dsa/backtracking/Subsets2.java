package com.tarif.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
	
	
	public int[][] subsetsWithDup(int[] A) {
		    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		    Arrays.sort(A);
	        subsetsWithDupUtil2(A, 0, new ArrayList<Integer>(), ans);
	        sortLexicographically(ans);
         int[][] res = new int[ans.size()][];
         for(int i=0; i<ans.size(); i++) {
	        	ArrayList<Integer> row = ans.get(i);
             int[] arr = new int[row.size()];
	        	for(int j=0; j<row.size(); j++) {
	        		arr[j] = row.get(j);
	        	}
             res[i] = arr;
	        }

	        return res;
	    }

     public void subsetsWithDupUtil2(int[] A, int ind, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> ans) {
		 if(A.length==ind) {
			 ArrayList<Integer> row = new ArrayList<Integer>();
			 for(int i=0; i<subSet.size(); i++) {
				 row.add(subSet.get(i));
			 }
			 ans.add(row);
			 return;
		 }
		 subSet.add(A[ind]);	 
		 subsetsWithDupUtil2(A, ind+1,subSet, ans);
		 subSet.remove(subSet.size()-1);
		 while(ind+1<A.length && A[ind] == A[ind+1]) {
			 ind++;
		 }
		 subsetsWithDupUtil2(A, ind+1,subSet,ans);
		 
	 }

  private void sortLexicographically(ArrayList<ArrayList<Integer>> ans) {
		 for(int i=0; i<ans.size()-1; i++) {
			 int min = i;
			 for(int j=i+1; j<ans.size(); j++) {
				 if(lesser(ans, min, j)) {
					 min = j;
				 }
			 }
			 if(min !=i) {
				 ArrayList<Integer> temp = ans.get(min);
				 ans.set(min, ans.get(i));
				 ans.set(i, temp);
			 }
		 }
	}

 private boolean lesser(ArrayList<ArrayList<Integer>> ans, int i, int j) {
		ArrayList<Integer> list1 = ans.get(i);
		ArrayList<Integer> list2 = ans.get(j);
		for(int ind =0; ind<list1.size() && ind<list2.size(); ind++) {
			if(list2.get(ind)<list1.get(ind)) {
				return true;
			}else if(list2.get(ind)>list1.get(ind)){
				return false;
			}
		}
		if(list1.size() > list2.size()) {
			return true;
		}
		return false;
	}

	 
	 public static void main(String[] args) {
		 Subsets2 sub = new Subsets2();
		 int[] A = {1,2,2};
		 int[][] ans = sub.subsetsWithDup(A);
		 for(int i=0; i<ans.length; i++) {
			 for(int j=0; j<ans[i].length; j++) {
				 System.out.print(ans[i][j]+" ");
			 }
			 System.out.println();
		 }
		 
	 }
	 
}
