package com.tarif.day048.dsa.stack1.implementationandbasicproblems;

import java.util.Scanner;

public class MinStack {
	int[] stack = new int[10000001];
    int top = -1;
    int min = 0;
    public void push(int x) {
        stack[++top] = x;
        if(stack[min] >=stack[top]){
            min = top;
        }
    }

    public void pop() {
        if(top!=-1){
            top--;
        }
    }

    public int top() {
        if(top==-1){
            return -1;
        }else{
            return stack[top];
        }
    }

    public int getMin() {
        if(top==-1){
            return -1;
        }else{
            return stack[min];
        }
    }
    
    public static void main(String[] args) {
    	MinStack ms = new MinStack();
    	Scanner sc = new Scanner(System.in);
    	//P 10 P 9 g P 8 g P 7 g P 6 g p g p g p g p g p g
    	//ans => 9 8 7 6 7 8 9 10 -1 
    	while(true) {
    		int c = sc.nextInt();
    		if(c==1) {
    			//push-->1
    			int n = sc.nextInt();
    			ms.push(n);
    			ms.printStack();
    		}else if(c==2) {
    			//pop-->2
    			ms.pop();
    			ms.printStack();
    		}else if(c==3) {
    			//top-->3
    			System.out.println(ms.top()+" ");
    			ms.printStack();
    		}else {
    			//min-->any
    			System.out.print(ms.getMin()+" ");
    			//ms.printStack();
    		}
    	}
    }
    
    public void printStack() {
    	for(int i=0; i<=top; i++) {
    		System.out.print(stack[i]+" ");
    	}
    	System.out.println();
    }

}
