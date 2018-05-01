package com.dream.arithmetic.str;

/**
 *  暴力匹配
 *  时间复杂度: O(m*n)
 */
public class BruteForce {

	public static boolean bruteForceV1(String origin, String target) {
		char[] ori = origin.toCharArray();
		char[] tar = target.toCharArray();
		int ort = ori.length;
		int tat = tar.length;
		if (ort < tat) {
			return false;
		}

		int i = 0;
		int j = 0;
		while (i < ort && j < tat) {
			if (ori[i] == tar[j]) {
				i++;
				j++;
			} else {
				i++;
				j = 0;
			}
		}
		if (j == tat) {
			return true;
		}

		return false;
	}

	public static boolean bruteForceV2(String origin, String target) {
		int n = origin.length();
		int m = target.length();
		int s = 0, j = 0;
		for (s = 0; s <= n - m; s++) {
			for (j = 0; j < m; j++) {
				if (origin.charAt(s + j) != target.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				return true;
			}
		}

		return false;
	}

}
