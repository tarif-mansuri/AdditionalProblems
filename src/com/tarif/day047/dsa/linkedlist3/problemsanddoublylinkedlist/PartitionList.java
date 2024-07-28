package com.tarif.day047.dsa.linkedlist3.problemsanddoublylinkedlist;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;
import com.tarif.day046.dsa.linkedlist2.sortinganddetectingloop.SwapNodesInPair;

public class PartitionList {
	public ListNode partition(ListNode A, int B) {
		ListNode h1 = null;
		ListNode t1 = null;
		ListNode h2 = null;
		ListNode t2 = null;
		while(A!=null) {
			if(A.val<B) {
				if(t1 == null) {
					h1 = A;
					t1 = h1;
				}else {
					t1.next = A;
					t1 = t1.next;
					
				}
				A = A.next;
				t1.next = null;
			}else {
				if(t2 == null) {
					h2 = A;
					t2 = h2;
				}else {
					t2.next = A;
					t2 = t2.next;
					
				}
				A = A.next;
				t2.next = null;
			}
		}
		if(t1!=null) {
			t1.next = h2;
			return h1;
		}else {
			return h2;
		}
    }
	public static void main(String[] args) {
		PartitionList partition = new PartitionList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(3);
		//head.next.next.next.next.next = new ListNode(2);
		//head.next.next.next.next.next.next = new ListNode(3);
//		head.next.next.next.next.next.next.next = new ListNode(8);
//		head.next.next.next.next.next.next.next.next = new ListNode(9);
		//head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		head = partition.partition(head, 2);
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	
}
