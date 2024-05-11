package com.tarif.day026.dsa.recursion2;

//	Problem Description
//	On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//	
//	Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
//	
//	
//	
//	Problem Constraints
//	1 <= A <= 105
//	
//	0 <= B <= min(2A - 1 - 1 , 1018)
//	
//	
//	
//	Input Format
//	First argument is an integer A.
//	
//	Second argument is an integer B.
//	
//	
//	
//	Output Format
//	Return an integer denoting the Bth indexed symbol in row A.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = 3
//	 B = 0
//	Input 2:
//	
//	 A = 4
//	 B = 4
//	
//	
//	Example Output
//	Output 1:
//	
//	 0
//	Output 2:
//	
//	 1
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 Row 1: 0
//	 Row 2: 01
//	 Row 3: 0110
//	Explanation 2:
//	
//	 Row 1: 0
//	 Row 2: 01
//	 Row 3: 0110
//	 Row 4: 01101001



public class KthSymbolHard {
    public int solve(int A, long B) {
        boolean ans = reccur(A, B, false);
        if(ans==false){
            return 0;
        }else{
            return 1;
        }
    }
    public boolean reccur(int A, long B,boolean res){
    	if(A==1) {
    		return res;
    	}
    	long mid = (long)(Math.pow(2, A-1)/2);
    	if(B<mid) {
    		return reccur(A-1, B, res);
    	}else {
    		B= B-(long)Math.pow(2, A-1)/2;
    		return reccur(A-1, B, !res);
    	}
    }
    public static void main(String[] args) {
    	KthSymbolHard kthSymbolHard = new KthSymbolHard();
    	//int[] q = {0,1,2,3,4,5,6,7};
    	int n=6;
    	for(int j=1; j<n; j++) {
    		for(int i=0; i<Math.pow(2, j-1);i++) {
        		System.out.print(kthSymbolHard.solve(j, i)+" ");
        	}
    		System.out.println();
    	}
    }

}
