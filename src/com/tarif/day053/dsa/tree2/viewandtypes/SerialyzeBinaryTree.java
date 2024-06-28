package com.tarif.day053.dsa.tree2.viewandtypes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerialyzeBinaryTree {
	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(A==null) {
			return ans;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node!=null) {
				ans.add(node.val);
				q.add(node.left);
				q.add(node.right);
			}else {
				ans.add(-1);
			}
			
		}
		return ans;
    }
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.right = new TreeNode(15);
//		head.left.left = new TreeNode(4);
//		head.left.right = new TreeNode(6);
//		head.right.left = new TreeNode(12);
		SerialyzeBinaryTree serialyze = new SerialyzeBinaryTree();
		ArrayList<Integer> ans = serialyze.solve(head);
		for(Integer i : ans) {
			System.out.print(i+" ");
		}
	}

}
