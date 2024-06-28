package com.tarif.day046.dsa.linkedlist2.sortinganddetectingloop;

import com.tarif.day045.dsa.linkedlist1.introduction.ListNode;

public class ReOrderList {
	public ListNode reorderList(ListNode A) {
        if(A==null || A.next==null){
            return A;
        }
        ListNode s = A;
        ListNode f = A;
        ListNode pre = null;
        while(f!=null && f.next != null){
            if(f.next.next == null){
                pre = s;
            }
            s = s.next;
            f = f.next.next;
        }
        if(pre!=null){
            pre.next = null;
        }
        if(f!=null && f.next == null){
            pre = s;
            s = s.next;
            pre.next=null;
        }
        s = reverse(s);
        ListNode ans = A;
        ListNode curr = ans;
        A = A.next;
        boolean AsTurn = false;
        while(A!=null && s!=null){
            if(AsTurn){
                 curr.next = A;
                 A = A.next;
                 curr = curr.next;
                 AsTurn = false;
            }else{
                curr.next = s;
                 s = s.next;
                 curr = curr.next;
                 AsTurn = true;
            }
           
        }
        if(A!=null){
            curr.next = A;
        }
        if(s!=null){
            curr.next = s;
        }
        return ans;
    }

    ListNode reverse(ListNode h){
        if(h==null || h.next==null){
            return h;
        }
        ListNode prev = null;
        ListNode curr = h;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		//head.next.next.next.next.next.next = new ListNode(70);
		ReOrderList reOrderList = new ReOrderList();
		System.out.println();
		
		ListNode ans = reOrderList.reorderList(head);
		while(ans!=null){
			System.out.print(ans.val+" ");
			ans = ans.next;
			
		}
	}

}
