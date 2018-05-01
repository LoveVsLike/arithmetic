package com.dream.arithmetic.temp;

public class RBTreeNode<T extends Comparable<T>> {
	private T data;
	private boolean red;//color is  red or not;
	private RBTreeNode<T> left;
	private RBTreeNode<T> right;
	private RBTreeNode<T> parent;
	
	public RBTreeNode() {
		
	}

	public RBTreeNode(T data) {
		this.data = data;
	}

	public RBTreeNode(T data, boolean red) {
		this.data = data;
		this.red = red;
	}
	
	//判断是否是叶子节点
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	//---setter getter方法

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	public RBTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(RBTreeNode<T> left) {
		this.left = left;
	}

	public RBTreeNode<T> getRight() {
		return right;
	}

	public void setRight(RBTreeNode<T> right) {
		this.right = right;
	}

	public RBTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(RBTreeNode<T> parent) {
		this.parent = parent;
	}	

}
