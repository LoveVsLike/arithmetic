package com.dream.arithmetic.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 伸展树:当某个节点被访问时，伸展树会通过旋转使该节点成为树根
 * https://dsa.cs.tsinghua.edu.cn/~deng/ds/src_link/_java/dsa/splaytree.java.htm
 * 
 * @author admin
 *
 */
public class SplayTree {
	public SplayTreeNode root;

	public static SplayTreeNode create() {
		return new SplayTreeNode();
	}

	public void insert(int data) {
		SplayTreeNode node = new SplayTreeNode(data);
		if (root == null) {
			root = node;
			return;
		}
		splay(data);
		if (data < root.data) {
			node.left = root.left;
			node.right = root;
			root.left = null;
		} else {
			node.right = root.right;
			node.left = root;
			root.right = null;
		}
		root = node;
	}

	public SplayTreeNode find(int data) {
		SplayTreeNode currentNode = find(root, data);
		splay(data);
		return currentNode;
	}

	/*
	 * 旋转key对应的节点为根节点，并返回根节点。
	 * 
	 * 注意： 
	 *  (a)：伸展树中存在"键值为key的节点"。 将"键值为key的节点"旋转为根节点。 
	 *  (b)：伸展树中不存在"键值为key的节点"，并且key <tree.key。
	 *           b-1 "键值为key的节点"的前驱节点存在的话，将"键值为key的节点"的前驱节点旋转为根节点。 
	 *           b-2 "键值为key的节点"的前驱节点不存在的话，则意味着，key比树中任何键值都小，那么此时，将最小节点旋转为根节点。
	 *  (c)：伸展树中不存在"键值为key的节点"，并且key > tree.key。 
	 *           c-1 "键值为key的节点"的后继节点存在的话，将"键值为key的节点"的后继节点旋转为根节点。
	 *           c-2 "键值为key的节点"的后继节点不存在的话，则意味着，key比树中任何键值都大，那么此时，将最大节点旋转为根节点。
	 */
	private static SplayTreeNode header = new SplayTreeNode();
	private void splay(int data) {
		SplayTreeNode l, r, t, y;
		l = r = header;
		t = root;
		header.left = header.right = null;
		for (;;) {
			if (data < t.data) {
				if (t.left == null)
					break;
				if (data < t.left.data) {
					y = t.left; /* rotate right */
					t.left = y.right;
					y.right = t;
					t = y;
					if (t.left == null)
						break;
				}
				r.left = t; /* link right */
				r = t;
				t = t.left;
			} else if (data > t.data) {
				if (t.right == null)
					break;
				if (data > t.data) {
					y = t.right; /* rotate left */
					t.right = y.left;
					y.left = t;
					t = y;
					if (t.right == null)
						break;
				}
				l.right = t; /* link left */
				l = t;
				t = t.right;
			} else {
				break;
			}
		}
		l.right = t.left; /* assemble */
		r.left = t.right;
		t.left = header.right;
		t.right = header.left;
		root = t;
	}

	// 树的层级遍历
	public void levelorder(SplayTreeNode node) {// 类似广度优先
		if (node == null)
			return;
		Queue<SplayTreeNode> queue = new LinkedList<SplayTreeNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			SplayTreeNode temp = queue.poll();
			System.out.println(temp.data + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	private SplayTreeNode find(SplayTreeNode root, int data) {
		SplayTreeNode currentNode = root;
		while (currentNode != null) {
			if (data < currentNode.data) {
				currentNode = currentNode.left;
				continue;
			}

			if (data > currentNode.data) {
				currentNode = currentNode.right;
				continue;
			}

			return currentNode;
		}

		return null;
	}

	public void remove(int data) {
		SplayTreeNode x;
		splay(data);
		// Now delete the root
		if (root.left == null) {
			root = root.right;
		} else {
			x = root.right;
			root = root.left;
			splay(data);
			root.right = x;
		}
	}

}

class SplayTreeNode {
	int data; // 关键字(键值)
	SplayTreeNode left; // 左孩子
	SplayTreeNode right; // 右孩子

	public SplayTreeNode() {

	}

	public SplayTreeNode(int data) {
		this.data = data;
	}

	public SplayTreeNode(int data, SplayTreeNode left, SplayTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}