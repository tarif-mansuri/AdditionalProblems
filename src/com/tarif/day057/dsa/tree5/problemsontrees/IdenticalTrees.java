package com.tarif.day057.dsa.tree5.problemsontrees;

import com.tarif.day053.dsa.tree2.viewandtypes.TreeNode;

public class IdenticalTrees {
	public int isSameTree(TreeNode A, TreeNode B) {
		if(isIdentical(A, B)) {
			return 1;
		}else {
			return 0;
		}
    }
	public boolean isIdentical(TreeNode A, TreeNode B) {
		if(A==null && B==null) {
			return true;
		}
		if(A==null || B==null || A.val != B.val) {
			return false;
		}
		return isIdentical(A.left, B.left) && isIdentical(A.right, B.right);
	}
}
