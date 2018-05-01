package com.dream.arithmetic.tree;

import org.junit.Test;

public class TrieTreeTest {
	
	@Test
	public void insert() {
		TrieTree tree = new TrieTree();
		tree.insert("aaaa");
		tree.insert("cdfc");
		TrieNode node = tree.root;
	}

}
