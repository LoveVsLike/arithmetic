package com.dream.arithmetic.tree;

import org.junit.Test;

public class AVLTreeTest {
	
	@Test
	public void insert() {
		AVLNode<Integer> root = new AVLNode<Integer>();
		root.data = 50;
		AVLTree<Integer> avl = new AVLTree<Integer>(root);
		avl.insert(25);
		avl.insert(12);
		avl.insert(6);
		avl.insert(3);
		avl.insert(2);
		avl.insert(1);
		
		avl.remove(3);
		avl.remove(1);
		avl.remove(2);
		System.out.println(avl.root);
	}

}
