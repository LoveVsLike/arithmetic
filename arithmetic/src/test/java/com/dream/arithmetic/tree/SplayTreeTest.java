package com.dream.arithmetic.tree;

import org.junit.Test;

public class SplayTreeTest {
	
	
	@Test
	public void test() {
		SplayTree splayTree = new SplayTree();
		splayTree.insert(23);
		splayTree.insert(20);
		splayTree.insert(25);
		splayTree.levelorder(splayTree.root);
		System.out.println("-------------");
		splayTree.insert(18);
		splayTree.levelorder(splayTree.root);
		
	}
	
	

}
