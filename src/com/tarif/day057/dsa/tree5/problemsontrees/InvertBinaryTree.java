package com.tarif.day057.dsa.tree5.problemsontrees;

import com.tarif.day053.dsa.tree2.viewandtypes.TreeNode;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode A) {
		if(A==null) {
			return A;
		}
		TreeNode temp = A.left;
		A.left = A.right;
		A.right = temp;
		A.left = invertTree(A.left);
		A.right = invertTree(A.right);
		return A;
    }
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(10);
		head.left.right = new TreeNode(30);
		InvertBinaryTree obj =new InvertBinaryTree();
		TreeNode ans = obj.invertTree(head);
		obj.print(ans);
	}
	public void print(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.val+ " ");
		print(root.left);
		print(root.right);
	}
}
