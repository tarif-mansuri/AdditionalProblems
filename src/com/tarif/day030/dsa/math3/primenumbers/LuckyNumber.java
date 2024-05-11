package com.tarif.day030.dsa.math3.primenumbers;

//	Problem Description
//	A lucky number is a number that has exactly 2 distinct prime divisors.
//	
//	You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
//	
//	
//	
//	Problem Constraints
//	1 <= A <= 50000
//	
//	
//	
//	Input Format
//	The first and only argument is an integer A.
//	
//	
//	
//	Output Format
//	Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = 8
//	Input 2:
//	
//	 A = 12
//	
//	
//	Example Output
//	Output 1:
//	
//	 1
//	Output 2:
//	
//	 3
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 Between [1, 8] there is only 1 lucky number i.e 6.
//	 6 has 2 distinct prime factors i.e 2 and 3.
//	Explanation 2:
//	
//	 Between [1, 12] there are 3 lucky number: 6, 10 and 12.


public class LuckyNumber {
	
	public int solve(int A) {
		int[] spf = new int[100000];
		populateSPF(spf);
		int ans = 0;
		for(int i=2; i<=A; i++) {
			int n = i; //checking for n
			int count = 0;
			while(n>1) {
				count++;
				int currSPF = spf[n];
				while(n%currSPF==0) {
					n = n/currSPF;
				}
			}
			if(count==2) {
				ans++;
			}
		}
		return ans;
    }
	public void populateSPF(int[] spf) {
		for(int i=2; i<spf.length; i++) {
			spf[i] = i;
		}
		for(int i=2; i*i<spf.length; i++) {
			for(int j=i*i; j<spf.length; j=j+i) {
				if(spf[j] == j) {
					if(j%i==0) {
						spf[j] = i;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		LuckyNumber ln = new LuckyNumber();
		int ans = ln.solve(12);
		System.out.println(ans);
	}
}
