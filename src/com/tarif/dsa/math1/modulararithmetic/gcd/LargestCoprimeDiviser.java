package com.tarif.dsa.math1.modulararithmetic.gcd;

public class LargestCoprimeDiviser {
public int cpFact(int A, int B) {
        
    int gcdCondition = gcd(A,B);    
	while(gcdCondition>1) {
        	A = A/gcdCondition;
        	gcdCondition = gcd(A,B);
        }
        return A;
    }

	public int gcd(int a, int b) {
		if(a==0) {
			return b;
		}else {
			return gcd(b%a , a);
		}
	}
	public static void main(String[] args) {
		LargestCoprimeDiviser lcd = new LargestCoprimeDiviser();
		System.out.print(lcd.cpFact(439221159, 609806152));
	}

}
