package com.dream.arithmetic.linked;

import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListTest {
	
	@Test
	public void test() {
		SingleLinkedList list = new SingleLinkedList();
		list.insert(1);
		list.insert(3);
		Assert.assertEquals(2, list.size());
		list.delete(1);
		Assert.assertEquals(1, list.size());
		Assert.assertTrue(list.find(3));
	}

}
