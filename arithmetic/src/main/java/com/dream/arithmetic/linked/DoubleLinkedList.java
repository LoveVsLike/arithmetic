package com.dream.arithmetic.linked;

public class DoubleLinkedList {
	DoubleNode head;
	DoubleNode tail;

	public boolean find(int data) {
		DoubleNode current = head;
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
		DoubleNode current = head;
		while (current != null) {
			current = current.next;
			count++;
		}

		return count;
	}

	public void insert(int data) {
		DoubleNode current = new DoubleNode(data);
		if (head == null) {
			head = current;
			tail = current;
		} else {
			current.next = head;
			head.prev = current;
			head = current;
		}
	}

	public void delete(int data) {
		DoubleNode current = head;
		while (current != null) {
			int d = current.data;
			if (d == data) {
				if (head == tail) {// 只有一个节点
					head = null;
					tail = null;
				} else {
					DoubleNode prev = current.prev;
					if (current == head) {
						head = current.next;
						current.next.prev = null;
						current.next = null;
					} else if (current == tail) {
						tail = prev;
						prev.next = null;
						current.prev = null;
					}else {
						prev.next = current.next;
						current.next.prev = prev;
					}
				}
				return;
			}
			current = current.next;
		}
	}

	public void print() {
		DoubleNode current = head;
		while (current != null) {
			int data = current.data;
			System.out.println(data);
			current = current.next;
		}
	}
}

class DoubleNode {
	public int data;
	public DoubleNode prev;
	public DoubleNode next;

	public DoubleNode() {

	}

	public DoubleNode(int data) {
		this.data = data;
	}

	public DoubleNode(int data, DoubleNode prev, DoubleNode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}
