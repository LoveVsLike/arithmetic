package com.dream.arithmetic.str;

import java.util.Arrays;

import org.junit.Test;

public class KMPTest {


	public void test() {
		boolean flag = KMP.kmp("b1cab c", "bc");
		System.out.println(flag);
	}
	
	@Test
	public void next() {
		String pattern = "sonsonb";
		int[] next = KMP.next(pattern);
		System.out.println(Arrays.toString(next));
	}

}
