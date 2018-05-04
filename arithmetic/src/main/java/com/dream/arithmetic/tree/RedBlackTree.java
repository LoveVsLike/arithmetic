package com.dream.arithmetic.tree;

/*
 * http://www.cnblogs.com/skywang12345/p/3245399.html
 */
public class RedBlackTree {
	public RedBlackNode root;

	public void insert(int data) {

	}

	public void remove(int data) {

	}

	// 左旋
	private void reverseLeft(RedBlackNode node) {
		RedBlackNode y = node.right;
		node.right = y.left;
		if (y.left != null)
			y.left.parent = node;
		y.parent = node.parent;
		if (node.parent == null) {
			root = y;
		} else {
			if (node.parent.left == node)
				node.parent.left = y;
			else
				node.parent.right = y;
		}

		y.left = node;
		node.parent = y;
	}

	// 右旋
	private void reverseRight(RedBlackNode y) {
		 // 设置x是当前节点的左孩子。
		RedBlackNode x = y.left;
	    y.left = x.right;
	    if (x.right != null)
	        x.right.parent = y;
	    x.parent = y.parent;
	    if (y.parent == null) {
	        root = x;
	    } else {
	        if (y == y.parent.right)
	            y.parent.right = x;
	        else
	            y.parent.left = x;
	    }
	    x.right = y;
	    y.parent = x;
	}
	
	
	
	

}
