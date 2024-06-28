package com.tarif.day045.dsa.linkedlist1.introduction;

public class LongestPalindromicList {
	public int solve(ListNode A) {
		ListNode prev = null;
		ListNode curr = A;
		int max = 1;
		while(curr!=null) {
			ListNode next = curr.next;
			curr.next = prev;
			int c1 = palLength(curr, next);
			int c2 = palLength(prev, next)+1;
			//System.out.println(c1+" "+c2);
			max = Math.max(max, Math.max(c1, c2));

			prev = curr;
			curr = next;
		}
		return max;
    }
	
	public int palLength(ListNode A, ListNode B) {
		int c =0;
		while(A!=null && B!=null) {
			if(A.val == B.val) {
				c = c+2;
			}else {
				break;
			}
			A = A.next;
			B = B.next;
		}
		return c;
	}
	
	public static void main(String[] args) {
		LongestPalindromicList lpl = new LongestPalindromicList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next.next.next = new ListNode(2);
		System.out.println(lpl.solve(head));
	}
	
}
