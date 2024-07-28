package com.tarif.day047.dsa.linkedlist3.problemsanddoublylinkedlist;

public class FlatenALinkedList {
	ListNode flatten(ListNode root) {
		if(root==null) {
			return root;
		}
		ListNode next = root.right;
		while(next!=null) {
			root = mergeSorted(root, next);
			next = next.right;
		}
	    return root;
	}
	
	public ListNode mergeSorted(ListNode h1, ListNode h2) {
		if(h1 == null) {
			return h2;
		}
		if(h2==null) {
			return h1;
		}
		ListNode h = null;
		ListNode t = null;
		if(h1.val<h2.val) {
			h = h1;
			t = h1;
			h1 = h1.down;
		}else {
			h = h2;
			t = h2;
			h2 = h2.down;
		}
		while(h1 !=null && h2!=null) {
			if(h1.val<h2.val) {
				t.down = h1;
				h1 = h1.down;
			}else {
				t.down = h2;
				h2 = h2.down;
			}
			t = t.down;
		}
		if(h1!=null) {
			t.down = h1;
		}
		if(h2!=null) {
			t.down = h2;
		}
		return h;
	}
	
	public static void main(String[] args) {
		FlatenALinkedList obj = new FlatenALinkedList();
		ListNode head = new ListNode(1);
		head.down = new ListNode(5);
		head.down.down = new ListNode(7);
		
		ListNode node = new ListNode(2);
		head.right = node;
		node.down = new ListNode(3);
		node.down.down = new ListNode(6);
		
		node.right = new ListNode(3);
		node = node.right;
		node.down = new ListNode(4);
		node.down.down = new ListNode(9);
		
		node.right = new ListNode(4);
		node = node.right;
		node.down = new ListNode(10);
		
//		ListNode temp = head.right.right.right;
//		while(temp!=null) {
//			System.out.print(temp.val+" ");
//			temp = temp.down;
//		}
		
		ListNode ans = obj.flatten(head);
		while(ans!=null) {
			System.out.print(ans.val+" ");
			ans = ans.down;
		}
	}
}



class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
