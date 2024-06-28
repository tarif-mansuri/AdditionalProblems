package com.tarif.day039.dsa.sorting2.quicksortandcomparatorproblems;

public class TensDigitSorting {
	public int[] solve(int[] A) {
        mergeSort(A, 0, A.length-1);
        return null;
    }
    public void mergeSort(int[] A, int l, int r) {
    	if(l<r) {
    		int m = (l+r)/2;
    		mergeSort(A, l, m);
    		mergeSort(A, m+1, r);
    		merge(A,l,m,r);
    	}
    }
    public void merge(int[] A, int l, int m, int r) {
    	int n1 = m-l+1;
    	int n2 = r-m;
    	int[] arr1 = new int[n1];
    	int[] arr2 = new int[n2];
    	for(int i=0; i<n1; i++) {
    		arr1[i] = A[l+i];
    	}
    	for(int i=0; i<n2; i++) {
    		arr2[i] = A[m+1+i];
    	}
    	int i=0;
    	int j=0;
    	int k=0;
    	while(i<n1 && j<n2) {
    		//arr1[i]<arr2[j]
    		int c = compare10s((arr1[i]%100)/10, (arr2[j]%100)/10);
    		if(c<0) {
    			A[k++] = arr1[i++];
    		}else if(c==0){
    			if(arr1[i]>arr2[j]) {
    				A[k++] = arr1[i++];
    			}else {
    				A[k++] = arr2[j++];
    			}
    		}else {
    			A[k++] = arr2[j++];
    		}
    	}
    	while(i<n1) {
    		A[k++] = arr1[i++];
    	}
    	while(j<n2) {
    		A[k++] = arr2[j++];
    	}
    }
    
    public int compare10s(int x, int y) {
    	return x-y;
    }
    
    public static void main(String[] args) {
    	int[] A = {70,10,40, 30};
    	TensDigitSorting tensDigSort = new TensDigitSorting();
    	tensDigSort.solve(A);
    	for(int i=0; i<A.length; i++) {
    		System.out.print(A[i]+" ");
    	}
    }

}
