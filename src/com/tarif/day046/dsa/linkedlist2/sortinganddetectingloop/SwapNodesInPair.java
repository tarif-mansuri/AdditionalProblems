package com.tarif.day046.dsa.linkedlist2.sortinganddetectingloop;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;

public class SwapNodesInPair {
	
	public ListNode swapPairs(ListNode A) {
		if(A.next == null) {
			return A;
		}
		ListNode start = new ListNode(0);
		start.next = A;
		ListNode curr = start;
		while(curr.next!=null && curr.next.next !=null) {
			curr.next = swap(curr.next, curr.next.next);
			curr = curr.next.next;
		}
		return start.next;
		
    }
	public ListNode swap(ListNode p1, ListNode p2) {
		p1.next = p2.next;
		p2.next = p1;
		return p2;
	}
	
	public static void main(String[] args) {
		SwapNodesInPair swapInPair = new SwapNodesInPair();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		//head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		head = swapInPair.swapPairs(head);
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}
