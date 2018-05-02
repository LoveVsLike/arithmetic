package com.dream.arithmetic.str;

/**
 * Boyer-Moore（BM）算法<br>
 * Boyer-Moore算法是一种基于后缀匹配的模式串匹配算法，后缀匹配就是模式串从右到左开始比较，但模式串的移动还是从左到右的。
 * 字符串匹配的关键就是模式串的如何移动才是最高效的，Boyer-Moore为了做到这点定义了两个规则：坏字符规则和好后缀规则<br>
 * 坏字符规则<bR>
 * 1.如果坏字符没有出现在模式字符中，则直接将模式串移动到坏字符的下一个字符：<br>
 * 2.如果坏字符出现在模式串中，则将模式串最靠近好后缀的坏字符（当然这个实现就有点繁琐）与母串的坏字符对齐：<br>
 * 好后缀规则<bR>
 * 1.模式串中有子串匹配上好后缀，此时移动模式串，让该子串和好后缀对齐即可，如果超过一个子串匹配上好后缀，则选择最靠靠近好后缀的子串对齐。<br>
 * 2.模式串中没有子串匹配上后后缀，此时需要寻找模式串的一个最长前缀，并让该前缀等于好后缀的后缀，寻找到该前缀后，让该前缀和好后缀对齐即可。<br>
 * 3.模式串中没有子串匹配上后后缀，并且在模式串中找不到最长前缀，让该前缀等于好后缀的后缀。此时，直接移动模式到好后缀的下一个字符。<br>
 *  
 *  参考:
 *  	http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
 *  时间复杂度：
 *     O(n/m)
 */
public class BoyerMoore {
	private final int R;     // the radix
    private int[] right;     // the bad-character skip array

    private String pattern;      // or as a string

    public BoyerMoore(String pattern) {
        this.R = 256;
        this.pattern = pattern;

        // position of rightmost occurrence of c in the pattern
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pattern.length(); j++)
            right[pattern.charAt(j)] = j;
    }

    public boolean search(String text) {
        int m = pattern.length();
        int n = text.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Math.max(1, j - right[text.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0) return true;    // found
        }
        return false;                      // not found
    }
}