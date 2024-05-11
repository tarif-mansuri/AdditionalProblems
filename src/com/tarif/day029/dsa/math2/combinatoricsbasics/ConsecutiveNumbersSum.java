package com.tarif.day029.dsa.math2.combinatoricsbasics;

public class ConsecutiveNumbersSum {
	public int solve(int A) {
		// Using formula x = (2.A-K.K+K)/(2.K)
		int k=1;
		int count = 0;
		int nom = 2*A - k*k + k;
		int denom = 2*k;
		while(nom>0){
			if(nom%denom==0)
			{
				count++;
			}
			k=k+1;
			nom = 2*A - k*k + k;
			denom = 2*k;
		}
		return count;
		
    }
	
	public static void main(String[] args) {
		ConsecutiveNumbersSum cns = new ConsecutiveNumbersSum();
		System.out.println(cns.solve(15));
	}
	
}
