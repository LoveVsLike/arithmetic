package com.dream.arithmetic.tree;

/**
 * avl树节点类
 * 
 * @author dream
 *
 */
public class AVLNode<T extends Comparable<T>> {
	public T data;
	public int high;
	public AVLNode<T> left;
	public AVLNode<T> right;

	public AVLNode() {
		
	}
	
	public AVLNode(T data) {
		this.data = data;
		this.high = 0;
	}

	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public AVLNode(T data, int high, AVLNode<T> left, AVLNode<T> right) {
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

	public AVLNode<T> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	public AVLNode<T> getRight() {
		return right;
	}

	public void setRight(AVLNode<T> right) {
		this.right = right;
	}

}
