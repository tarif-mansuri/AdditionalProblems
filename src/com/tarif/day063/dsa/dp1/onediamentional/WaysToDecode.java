package com.tarif.day063.dsa.dp1.onediamentional;

//https://www.youtube.com/watch?v=jFZmBQ569So

public class WaysToDecode {
	
	public int numDecodings(String A) {
		if(A.charAt(0)=='0'){
			return 0;
		}
		if(A.length()==1 || A.length()==0) {
			return 1;
		}
		int MOD = 1000000007;
		int[] dp = new int[A.length()+1];
		dp[0] = 1;
		char a = A.charAt(0);
		char b = A.charAt(1);
		if(a>'2') {
			if(b=='0') {
				dp[1] = 0;
			}else {
				dp[1] = 1;
			}
		}else if(a<='2') {
			if(b=='0') {
				dp[1] = 1;
			}else {
				dp[1] = 2;
			}
		}
		for(int i=2; i<A.length(); i++) {
			if(A.charAt(i-1) == '0' && A.charAt(i) == '0') {
				dp[i] = 0;
			}else if(A.charAt(i-1) > '0' && A.charAt(i) == '0') {
				if(A.charAt(i-1)>'2') {
					dp[i] = 0;
				}else {
					dp[i] = dp[i-2];
				}
			}else if(A.charAt(i-1) == '0' && A.charAt(i) > '0') {
				dp[i] = dp[i-1];
			}else {
				//both are non zero
				int k = Integer.parseInt(A.substring(i-1, i+1));
				if(k<=26) {
					dp[i] = dp[i-1]+dp[i-2];
				}else {
					dp[i] = dp[i-1];
				}
			}
		}
		return dp[A.length()-1];
    }
	
	public static void main(String[] args) {
		WaysToDecode obj = new WaysToDecode();
		System.out.println(obj.numDecodings("1711"));
	}

}
