package com.tarif.day042.dsa.binarysearch.onanswers;

public class AllocateBooks {
	public int books(int[] A, int B) {
		if(B>A.length) {
			return -1;
		}
        int l=Integer.MIN_VALUE;
        int r = 0;
        for(int i=0; i<A.length; i++) {
        	if(l<A[i]) {
        		l = A[i];
        	}
        	r +=A[i];
        }
		int ans = 0;
		while(l<=r) {
			int mid = l+(r-l)/2;
			if(isPossible(A, B, mid)) {
				ans = mid;
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		return ans;
    }
    private boolean isPossible(int[] A, int B, int mid) {
    	
		int studentsCount = 1;
		int remMid = mid;
		for(int i=0; i<A.length; i++) {
			if(A[i]>mid) {
				return false;
			}
			if(remMid>=A[i]) {
				remMid -=A[i]; 
			}else {
				remMid = mid-A[i];
				studentsCount++;
				if(studentsCount>B) {
					return false;
				}
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
    	int[] A = {12, 34, 67, 90};
    	AllocateBooks ab = new AllocateBooks();
		System.out.println(ab.books(A, 2));
    }

}
