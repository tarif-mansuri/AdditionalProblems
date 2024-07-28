package com.tarif.day057.dsa.tree5.problemsontrees;

import com.tarif.day053.dsa.tree2.viewandtypes.TreeNode;

public class SumBinaryTreeOrNot {
	boolean ans = true;
	public int solve(TreeNode A) {
		ans = true;
		getSum(A);
		if(ans) {
			return 1;
		}else {
			return 0;
		}
    }
	public int getSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return root.val;
		}
		int lSum = getSum(root.left);
		int rSum = getSum(root.right);
		if(root.val != lSum+rSum) {
			ans = false;
		}
		return root.val + lSum + rSum;
	}
	public static void main(String[] args) {
		TreeNode head = new TreeNode(16);
		head.left = new TreeNode(2);
		head.right = new TreeNode(6);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(1);
		head.right.left = new TreeNode(3);
		head.right.right = new TreeNode(3);
		SumBinaryTreeOrNot sumBinaryTree = new SumBinaryTreeOrNot();
		System.out.println(sumBinaryTree.solve(head));
	}

}
