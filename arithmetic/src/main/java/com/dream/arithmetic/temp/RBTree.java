package com.dream.arithmetic.temp;

import java.util.concurrent.atomic.AtomicLong;

public class RBTree<T extends Comparable<T>> {
	private final RBTreeNode<T> root;
	private AtomicLong size = new AtomicLong(0);
	
	public RBTree() {
		root = new RBTreeNode<T>();
	}
	
	public T insert(T value) {
		RBTreeNode<T> node = new RBTreeNode<T>(value);
		return insert(node);
	}
	
	private T insert(RBTreeNode<T> node) {
		node.setLeft(null);
		node.setRight(null);
		node.setRed(true);
		setParent(node, null);
		if(root.getLeft() == null) {
			root.setLeft(node);
			node.setRed(false);
			size.incrementAndGet();
		}else {
			
		}
		
		return null;
		
	}
	
	private void setParent(RBTreeNode<T> node,RBTreeNode<T> parent) {
		if(node != null) {
			node.setParent(parent);
			if(parent == root) {
				node.setParent(null);
			}
		}
	}

}
