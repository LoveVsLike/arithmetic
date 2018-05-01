package com.dream.arithmetic.str;

import org.junit.Test;

public class SundayTest {
	
	@Test
	public void SundayV1() {
		String text = "are you ok";
		String pattern = "ok";
		int position = Sunday.sundayV1(text, pattern);
		System.out.println(position);
	}

}
