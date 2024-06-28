package com.tarif.day053.dsa.tree2.viewandtypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfTree {
	public ArrayList<Integer> solve(TreeNode A) {
		int min = 0;
		int max = 0;
		TreeNode temp = A;
		while(temp!=null && temp.left !=null) {
			temp=temp.left;
			min--;
		}
		temp = A;
		while(temp!=null && temp.right !=null) {
			temp=temp.right;
			max++;
		}
		//System.out.print(min+" "+max);
		HashMap<TreeNode, Integer> reverseLookUp = new HashMap<>();
		HashMap<Integer, TreeNode> lookUp = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		lookUp.put(0, A);
		reverseLookUp.put(A, 0);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node.left!=null) {
				if(!lookUp.containsKey(reverseLookUp.get(node)-1)) {
					lookUp.put(reverseLookUp.get(node)-1, node.left);
				}
				reverseLookUp.put(node.left, reverseLookUp.get(node)-1);
				q.add(node.left);
			}
			if(node.right!=null) {
				if(!lookUp.containsKey(reverseLookUp.get(node)+1)) {
					lookUp.put(reverseLookUp.get(node)+1, node.right);
				}
				reverseLookUp.put(node.right, reverseLookUp.get(node)+1);
				q.add(node.right);
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(min<=max) {
			ans.add(lookUp.get(min).val);
			min++;
		}
		return ans;
		
    }
	public static void main(String[] args) {
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.right = new TreeNode(15);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(6);
		head.right.left = new TreeNode(12);
		TopViewOfTree tvot = new TopViewOfTree();
		ArrayList<Integer> ans = tvot.solve(head);
		for(Integer i : ans) {
			System.out.print(i+" ");
		}
	}

}
