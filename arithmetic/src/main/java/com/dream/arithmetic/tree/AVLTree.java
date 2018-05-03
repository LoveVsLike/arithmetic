package com.dream.arithmetic.tree;

public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> root;

	public AVLTree(AVLNode<T> root) {
		this.root = root;
	}

	public void insert(T data) {
		this.root = insert(root, data);
	}

	private AVLNode<T> insert(AVLNode<T> node, T data) {
		if (node == null) {
			node = new AVLNode<T>(data);
		}

		int compare = data.compareTo(node.getData());
		if (compare < 0) {// 向左插入数据 data 小于 node
			node.left = insert(node.left, data);
			if (height(node.left) - height(node.right) == 2) {
				if (data.compareTo(node.left.data) < 0) {
					node = reverseLeft(node);
				} else {
					node = reverseDoubleLeft(node);
				}
			}
		} else if (compare > 0) {// 向右插入数据
			node.right = insert(node.right, data);
			if (height(node.right) - height(node.left) == 2) {
				if (data.compareTo(node.right.data) < 0) {
					node = reverseDoubleRight(node);
				} else {
					node = reverseRight(node);
				}
			}
		}

		node.high = Math.max(height(node.left), height(node.right)) + 1;

		return node;
	}

	private int height(AVLNode<T> node) {
		return node != null ? node.high : 0;
	}

	// LL
	private AVLNode<T> reverseLeft(AVLNode<T> node) {
		AVLNode<T> w = node.left;
		node.left = w.right;
		w.right = node;
		node.high = node.high - 1;
		w.high = w.high + 1;

		return w;
	}

	// RR
	private AVLNode<T> reverseRight(AVLNode<T> node) {
		AVLNode<T> x = node.right;
		node.right = x.left;
		node.high = x.high;
		x.high = x.high + 1;

		return x;
	}

	// LR
	private AVLNode<T> reverseDoubleLeft(AVLNode<T> node) {
		node.left = reverseRight(node.left);
		return reverseLeft(node);
	}

	// RL
	private AVLNode<T> reverseDoubleRight(AVLNode<T> node) {
		node.left = reverseLeft(node.left);
		return reverseRight(node);
	}

	public void remove(T data) {
		if (data == null) {
			return;
		}
		this.root = remove(root, data);
	}

	private AVLNode<T> remove(AVLNode<T> p, T data) {
		return null;
	}

}
