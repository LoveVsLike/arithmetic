package com.dream.arithmetic.temp;

public class AVLTree<T extends Comparable<T>> {
	private AVLTreeNode<T> root;
	
	public AVLTree(AVLTreeNode<T> root) {
		this.root = root;
	}
	
	public void insert(T data) {
		this.root = insert(root,data);
	}
	
	private int height(AVLTreeNode<T> node) {
		return node != null ? node.high : 0; 
	}
	
	private AVLTreeNode<T> insert(AVLTreeNode<T> node,T data) {
		if(node == null) {
			node = new AVLTreeNode<T>(data);
		}
		
		int compare = data.compareTo(node.getData());
		if(compare < 0) {//向左插入数据  data 小于 node
			node.left = insert(node.left, data);
			if(height(node.left)-height(node.right) == 2) {
				if(data.compareTo(node.left.data) < 0) {
					node = reverseLeft(node);
				}else {
					node = reverseDoubleLeft(node);
				}
			}
		}else if(compare > 0) {//向右插入数据
			node.right = insert(node.right, data);
			if(height(node.right)-height(node.left) == 2) {
				if(data.compareTo(node.right.data) < 0) {
					node = reverseDoubleRight(node);
				}else {
					node = reverseRight(node);
				}
			}
		}
		
		node.high = Math.max(height(node.left), height(node.right))+1;
		
		return node;
	}
	
	private AVLTreeNode<T> reverseLeft(AVLTreeNode<T> node) {
		AVLTreeNode<T> w = node.left;
		node.left = w.right;
		w.right = node;
		node.high = node.high-1;
		w.high = w.high+1;
		
		return w;
	}
	
	private AVLTreeNode<T> reverseRight(AVLTreeNode<T> node){
		AVLTreeNode<T> x = node.right;
		node.right = x.left;
		node.high = x.high;
		x.high = x.high + 1;
		
		return x;
	}
	
	private AVLTreeNode<T> reverseDoubleLeft(AVLTreeNode<T> node){
		node.left = reverseRight(node.left);
		return reverseLeft(node);
	}
	
	private AVLTreeNode<T> reverseDoubleRight(AVLTreeNode<T> node){
		node.left = reverseLeft(node.left);
		return reverseRight(node);
	}
	
	public static void main(String[] args) {
		
	}

}
