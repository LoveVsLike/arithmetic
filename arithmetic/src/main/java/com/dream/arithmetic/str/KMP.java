package com.dream.arithmetic.str;

/**
 * 时间复杂度为： O(m+n)
 * 参考:KMP
 *    http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 */
public class KMP {
    /**
     * 
     * @param pattern
     * @return
     */
	public static int[] next(String pattern) {
		int[] next = new int[pattern.length()];
		//模版字符串的第一个字符的最大前后缀长度为0 
		next[0] = 0;
		//i: 模版字符串下标  j: :最大前后缀长度
		for (int i = 1, j = 0; i < pattern.length(); i++) {
			//递归的求出pattern[0]···pattern[i]的最大的相同的前后缀长度j
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = next[j - 1];
			}
			//如果相等，那么最大相同前后缀长度加1
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		
		return next;
	}

	public static boolean kmp(String text, String pattern) {
		int[] next = next(pattern);
		for (int i = 0, j = 0; i < text.length(); i++) {
			while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = next[j - 1];
			}
			if (text.charAt(i) == pattern.charAt(j)) {
				j++;
			}
			if (j == pattern.length()) {
				return true;
			}
		}
		return false;
	}

}
