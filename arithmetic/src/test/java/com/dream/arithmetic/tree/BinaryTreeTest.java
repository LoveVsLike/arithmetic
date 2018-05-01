package com.dream.arithmetic.tree;

import org.junit.Test;

public class BinaryTreeTest {
	
	@Test
	public void test() {
		BinaryTree tree = new BinaryTree();
		tree.insert(100);
		tree.insert(90);
		tree.insert(110);
		tree.insert(85);
		tree.insert(95);
		tree.insert(105);
		tree.insert(115);
		tree.preorder();
		System.out.println("---------------------");
		MorrisBinaryTree t = new MorrisBinaryTree();
		t.preorder(tree.root);
		//tree.preorder(tree.root);
	}

}
