package com.dream.arithmetic.linked;

import org.junit.Assert;
import org.junit.Test;

public class DoubleLinkedListTest {
	
	public void test() {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insert(23);
		System.out.println(list.size());
		list.print();
	}
	
	@Test
	public void testsingle() {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insert(23);
		Assert.assertEquals(1, list.size());
		list.delete(23);
		Assert.assertEquals(0, list.size());
	}

	@Test
	public void testDouble() {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insert(23);
		list.insert(22);
		Assert.assertEquals(2, list.size());
		list.delete(22);
		Assert.assertEquals(1, list.size());
	}
	
}
