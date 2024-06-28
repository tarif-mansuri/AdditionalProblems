package com.tarif.day048.dsa.stack1.implementationandbasicproblems;

import java.util.Stack;

public class RedundantBraces {
	public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) !=')' && !(A.charAt(i)>='a' && A.charAt(i)<='z')){
                stack.push(A.charAt(i));
            }
            if(A.charAt(i) ==')'){
                if(stack.peek()=='('){
                    return 1;
                }else{
                    char c = stack.pop();
                    while(!stack.isEmpty() && c!='('){
                        c = stack.pop();
                    }
                }
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		RedundantBraces redB = new RedundantBraces();
		System.out.println(redB.braces("(a+(a+b))"));
	}

}
