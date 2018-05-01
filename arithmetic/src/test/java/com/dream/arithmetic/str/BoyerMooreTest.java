package com.dream.arithmetic.str;

import org.junit.Test;

public class BoyerMooreTest {
	
	@Test
	public void boyerMoore() {
		String parren = "son";
		BoyerMoore bm = new BoyerMoore(parren);
		System.out.println(bm.search("s1ondsfso3ndfsfdso2n"));
	}

}
