package com.tarif.day045.dsa.linkedlist1.introduction;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode A, int B) {

		ListNode head = A;
		if (head == null || (head.next == null && B == 1)) {
			return null;
		}
		int count = 0;

		while (head != null) {
			count++;
			head = head.next;
		}
		if(B>=count) {
			return A.next;
		}
		count = count - B;
		head = A;
		count--;
		while (head != null && count-- > 0) {
			head = head.next;
		}
		head.next = head.next.next;
		return A;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		head.next.next.next.next.next.next = new ListNode(70);
		RemoveNthNodeFromEnd rnthnodeEnd = new RemoveNthNodeFromEnd();
		ListNode h = head;
		while(h!=null){
			System.out.print(h.val+" ");
			h = h.next;
			
		}
		System.out.println();
		
		ListNode ans = rnthnodeEnd.removeNthFromEnd(head,70);
		while(ans!=null){
			System.out.print(ans.val+" ");
			ans = ans.next;
			
		}
	}

}
