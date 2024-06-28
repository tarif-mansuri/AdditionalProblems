package com.tarif.day053.dsa.tree2.viewandtypes;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderBT {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		s1.push(A);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			while(!s1.isEmpty()) {
				TreeNode node = s1.pop();
				if(node.left!=null) {
					s2.push(node.left);
				}
				if(node.right!=null) {
					s2.push(node.right);
				}
				row.add(node.val);
			}
			if(row.size()>0) {
				ans.add(row);
			}
			row = new ArrayList<Integer>();
			while(!s2.isEmpty()) {
				TreeNode node = s2.pop();
				if(node.right!=null) {
					s1.push(node.right);
				}
				if(node.left!=null) {
					s1.push(node.left);
				}
				row.add(node.val);
			}
			if(row.size()>0) {
				ans.add(row);
			}
		}
		return ans;
    }
	public void insert(Queue<TreeNode> q, TreeNode node) {
		if(node!=null) {
			q.add(node);
		}
	}
	
	public static void main(String[] args) {
		ZigZagLevelOrderBT zigZag = new ZigZagLevelOrderBT();
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.right = new TreeNode(15);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(6);
		head.right.left = new TreeNode(12);
		ArrayList<ArrayList<Integer>> ans = zigZag.zigzagLevelOrder(head);
		
		for(ArrayList<Integer> list : ans) {
			for(Integer i : list) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}

}
