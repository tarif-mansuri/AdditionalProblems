package com.tarif.day047.dsa.linkedlist3.problemsanddoublylinkedlist;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;
import com.tarif.day046.dsa.linkedlist2.sortinganddetectingloop.SwapNodesInPair;

public class PartitionList {
	public ListNode partition(ListNode A, int B) {
		ListNode greaterOrEqualHead = null;
		ListNode greaterOrEqualTail = null;
		ListNode lesserHeah = null;
		ListNode lesserTail = null;
		
		while(A!=null) {
			if(A.val<B) {
				if(lesserHeah==null) {
					lesserHeah = A;
					lesserTail = A;
				}else {
					lesserTail.next = A;
				}
			}else {
				if(greaterOrEqualHead==null) {
					greaterOrEqualHead = A;
					greaterOrEqualTail = A;
				}else {
					greaterOrEqualTail.next = A;
				}
			}
			A = A.next;
		}
		
		//Printing for debugging
		ListNode temp = lesserHeah;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
		temp = greaterOrEqualHead;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		return null;
    }
	public static void main(String[] args) {
		PartitionList partition = new PartitionList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next = new ListNode(7);
//		head.next.next.next.next.next.next.next = new ListNode(8);
//		head.next.next.next.next.next.next.next.next = new ListNode(9);
		//head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		head = partition.partition(head, 4);
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	
}
