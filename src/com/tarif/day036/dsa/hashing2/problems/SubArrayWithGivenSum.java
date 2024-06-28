package com.tarif.day036.dsa.hashing2.problems;


public class SubArrayWithGivenSum {
	public int[] solve(int[] A, int B) {
        int i=0;
        int j=1;
        long sum = A[0];
        while(true){
            if(sum == B){
                //create array and return
            	j--;
            	int[] ans = new int[j-i+1];
            	for(int l=0; l<ans.length; l++) {
            		ans[l] = A[i++];
            	}
            	return ans;
            }else if(sum>B) {
            	sum -=A[i];
            	i++;
            }else {
            	if(j<A.length) {
            		sum+=A[j];
                	j++;
            	}else {
            		break;
            	}
            }
        }
        int[] ans = new int[1];
        ans[0] = -1;
        return ans;
    }
	public static void main(String[] args) {
		SubArrayWithGivenSum subArrayWithGivenSum = new SubArrayWithGivenSum();
		int[] A = {1,1000000000};
		
		int[] ans = subArrayWithGivenSum.solve(A, 1000000000);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
