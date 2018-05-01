package com.dream.arithmetic.linked;

/**
 * 
 * @author admin
 *
 */
public class SingleLinkedList {
	private Node root;

	public boolean find(int data) {
		if (root == null) {
			return false;
		}

		Node current = root;
		while (current != null) {
			int d = current.data;
			if (d == data) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	public int size() {
		int count = 0;
		Node current = root;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public void insert(int data) {
		Node node = new Node(data);
		if(root == null) {
			root=node;
		}else {
			Node pre = root;
			Node current = root;
			while(current != null) {
				pre = current;
				current = current.next;
			}
			pre.next = node;
		}
	}

	public void delete(int data) {
		Node pre = null;
        Node current = root;
        while(current != null) {
        	pre = current;
        	int d = current.data;
        	if(d == data) {
        		if(pre == root) {//删除的是root
        			root = pre.next; 
        			return;
        		}else {
        			pre.next = current.next;
        		}
        	}
        	current = current.next;
        }
	}
	
	public void print() {
		Node current = root;
		while(current != null) {
			int data = current.data;
			System.out.println(data);
			current = current.next;
		}
	}
}

class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
	}

	public Node(Node next, int data) {
		this.data = data;
		this.next = next;
	}
}
