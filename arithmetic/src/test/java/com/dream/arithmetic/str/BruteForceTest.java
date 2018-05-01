package com.dream.arithmetic.str;

import org.junit.Test;

import org.junit.Assert;

public class BruteForceTest {
	
	@Test
	public void bruteForceV1() {
		String origin = "are you ok, please open door";
		String target = "please";
		boolean condition = BruteForce.bruteForceV1(origin, target);
		Assert.assertTrue(condition);
	}
	
	@Test
	public void bruteForceV2() {
		String origin = "are you ok, please open door";
		String target = "door";
		boolean condition = BruteForce.bruteForceV2(origin, target);
		Assert.assertTrue(condition);
	}

}
