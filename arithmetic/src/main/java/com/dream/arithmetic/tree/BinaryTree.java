package com.dream.arithmetic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	public BinaryNode root;

	public void insert(int data) {
		BinaryNode node = new BinaryNode(data);
		if (root == null) {// 根节点为空
			this.root = node;
		} else {
			BinaryNode current = root;
			while (true) {
				if (data < current.data) {// 向左移动
					if (current.left == null) {
						current.left = node;
						return;
					}
					current = current.left;
				}

				if (data > current.data) {// 向右移动
					if (current.right == null) {
						current.right = node;
						return;
					}
					current = current.right;
				}
			}
		}
	}

	/**
	 * 递归实现
	 */
	public BinaryNode insert(int data, BinaryNode node) {
		if (node == null) {
			return new BinaryNode(data);
		}
		if (data < node.data)
			node.left = insert(data, node.left);
		else if (data > node.data)
			node.right = insert(data, node.right);
		return node;
	}

	// 删除节点分三种方式删除节点
	// 1、删除没有子节点的节点，直接让该节点的父节点的左节点或右节点指向空
	// 2、删除有一个子节点的节点，直接让该节点的父节点指向被删除节点的剩余节点
	// 3、删除有三个节点的子节点，找到要删除节点的后继节点， 用该节点替代删除的节点
	public boolean delete(int data) {
		if (root == null)
			return false;
		// 首先查找节点，并记录该节点的父节点引用
		BinaryNode current = root;
		BinaryNode parent = root;
		boolean isLeftNode = true;
		while (current.data != data) {
			parent = current;
			if (data < current.data) {
				isLeftNode = true;
				current = current.left;
			} else {
				isLeftNode = false;
				current = current.right;
			}
		}

		if (current.data != data) {
			System.out.println("没有找到要删除的节点！");
			return false;
		}

		// 下面分三种情况删除节点
		if (current.left == null && current.right == null) { // 要删除的节点没有子节点
			if (current == root) { // 根节点就删除整棵树
				root = null;
			} else if (isLeftNode) { // 如果是左节点，做节点指向空
				parent.left = null;
			} else { // 如果是右节点，右节点指向空
				parent.right = null;
			}
		} else if (current.left == null) { // 要删除的节点只有右节点
			if (current == root) {
				root = current.right;
			} else if (isLeftNode) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.right == null) {// 要删除的节点只有左节点
			if (current == root) {
				root = current.left;
			} else if (isLeftNode) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else {// 要删除的节点有两个节点
			BinaryNode successor = findSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftNode) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}

		return true;
	}

	/**
	 * 有两种方案： 第一种方案：查找左节点最大值 第二种方案：查找右边最小值
	 * 
	 * @param delNode
	 * @return
	 */
	private BinaryNode findSuccessor(BinaryNode delNode) {
		BinaryNode parent = delNode; // 200
		BinaryNode successor = delNode; // 200
		BinaryNode current = delNode.right; // 350
		while (current != null) {// 找的最左节点
			parent = successor;
			successor = current; // 350
			current = current.left; // null
		}
		// 这段代码的作用是当后继节点不是被删除节点的右节点并且后继结点有右节点的情况下的时候做的操作
		if (successor != delNode.right) {
			parent.left = successor.right;
			successor.right = delNode.right;
		}

		return successor;
	}

	// 删除某个节点下面的所有节点
	public BinaryNode remove(int data, BinaryNode node) {
		if (node == null)
			return node;// 没有找到,doNothing
		if (data > node.data)
			node.right = remove(data, node.right);
		else if (data < node.data)
			node.left = remove(data, node.left);
		else if (node.left != null && node.right != null) {
			node.data = min(node.right).data;
			node.right = remove(node.data, node.right);
		} else
			node = (node.left != null) ? node.left : node.right;
		return node;

	}

	// 前序遍历：根左右
	public void preorder(BinaryNode node) {
		if (node != null) {
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	// 前序遍历：根左右 非递归实现
	public void preorder() {//dfs 同时也是深度优先
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		BinaryNode node = root;
		while (node != null || stack.size() > 0) { // 将所有左孩子压栈
			if (node != null) { // 压栈之前先访问
				System.out.println(node.data);
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				node = node.right;
			}
		}
	}

	// 中序遍历：左根右
	public void inorder(BinaryNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}

	// 中序遍历：左根右 非递归实现
	public void inorder() {
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		BinaryNode node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				stack.push(node); // 直接压栈
				node = node.left;
			} else {
				node = stack.pop(); // 出栈并访问
				System.out.println(node.data);
				node = node.right;
			}
		}
	}

	// 后续遍历: 左右根
	public void postorder(BinaryNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}

	// 后续遍历: 左右根
	public void postorder() {
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		Stack<BinaryNode> output = new Stack<BinaryNode>();// 构造一个中间栈来存储逆后序遍历的结果
		BinaryNode node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				output.push(node);
				stack.push(node);
				node = node.right;
			} else {
				node = stack.pop();
				node = node.left;
			}
		}
		while (output.size() > 0) {
			BinaryNode temp = output.pop();
			System.out.println(temp.data);
		}
	}

	public void levelOrder() {
		int depth = depth(root);
		for (int i = 1; i <= depth; i++) {
			levelorder(root, i);
		}
	}

	private void levelorder(BinaryNode node, int level) {
		if (node == null || level < 1) {
			return;
		}
		if (level == 1) {
			System.out.print(node.data + "  ");
			return;
		}
		levelorder(node.left, level - 1);
		levelorder(node.right, level - 1);
	}

	public int depth(BinaryNode node) {
		if (node == null) {
			return 0;
		}
		int l = depth(node.left);
		int r = depth(node.right);
		if (l > r) {
			return l + 1;
		} else {
			return r + 1;
		}
	}

	// 树的层级遍历
	public void levelorder(BinaryNode node) {//类似广度优先
		if (node == null)
			return;
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BinaryNode temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	public BinaryNode find(int data) {
		return find(root, data);
	}

	private BinaryNode find(BinaryNode node, int data) {
		if (node == null)
			return null;
		if (data < node.data) {
			return find(node.left, data);
		}

		if (data > node.data) {
			return find(node.right, data);
		}

		return node;
	}

	public BinaryNode min() {
		return min(root);
	}

	// 求最小值节点
	private BinaryNode min(BinaryNode root) {
		if (root != null) {
			BinaryNode node = root;
			while (node.left != null) {
				node = node.left;
			}

			return node;
		}

		return root;
	}

	// 求最大值节点
	public BinaryNode max() {
		if (root != null) {
			BinaryNode node = root;
			while (node.right != null) {
				node = node.right;
			}

			return node;
		}
		return root;
	}

}

class BinaryNode {
	public int data;
	public BinaryNode left;
	public BinaryNode right;

	public BinaryNode(int data) {
		this.data = data;
	}

	public BinaryNode(int data, BinaryNode left, BinaryNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
