package com.dream.arithmetic.temp;

/**
 * avl树节点类
 * 
 * @author dream
 *
 */
public class AVLTreeNode<T extends Comparable<T>> {
	public T data;
	public int high;
	public AVLTreeNode<T> left;
	public AVLTreeNode<T> right;

	public AVLTreeNode() {
		
	}
	
	public AVLTreeNode(T data) {
		this.data = data;
		this.high = 0;
	}

	public AVLTreeNode(T data, AVLTreeNode<T> left, AVLTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public AVLTreeNode(T data, int high, AVLTreeNode<T> left, AVLTreeNode<T> right) {
		super();
		this.data = data;
		this.high = high;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public AVLTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(AVLTreeNode<T> left) {
		this.left = left;
	}

	public AVLTreeNode<T> getRight() {
		return right;
	}

	public void setRight(AVLTreeNode<T> right) {
		this.right = right;
	}

}
