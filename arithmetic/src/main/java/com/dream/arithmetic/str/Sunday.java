package com.dream.arithmetic.str;

/**
 * Sunday算法<BR>
 * 核心思想是：在匹配过程中，模式串发现不匹配时，算法能跳过尽可能多的字符以进行下一步的匹配，从而提高了匹配效率。Sunday算法在单模式字符串搜索算法中应该是最快的算法，比KMP一级BM都要快<br>
 * 算法用例<BR>
 * 匹配串：O U R S T R O N G X S E A R C H<BR>
 * 模式串：S E A R C H<BR>
 * 这里我们看到O-S不相同，我们就看匹配串中的O在模式串的位置，没有出现在模式串中。<BR>
 * 匹配串：O U R S T R O N G X S E A R C H<Br>
 * 模式串：____________S E A R C H<BR>
 * 移动模式串，使模式串的首字符和O的下一个字符对齐。<BR>
 * 匹配串：O U R S T R O N G X S E A R C H<BR>
 * 模式串：____________________S E A R C H<BR>
 * 匹配完成<Br>
 * 
 * Sunday核心思想：
 * 1 需要记录匹配串的下个字符在模式串中的位置
 * 2 如果未找到，则移动整个模式串的长度
 * 3 如果找到，则移动最右边长度的模式串长度
 *
 */
public class Sunday {

	public static int getIndex(String pattern, Character c) {
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) == c)
                return i;
        }
        return -1;
    }

    public static int sundayV1(String text, String pattern) {
        int M = text.length();
        int N = pattern.length();
        int i, j;
        int skip = -1;
        for (i = 0; i <= M - N; i += skip) {
            for (j = 0; j < N; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)){
                    if (i == M - N)
                        break;
                    skip = N - getIndex(pattern, text.charAt(i + N));
                    break;
                }
            }
            if (j == N)
                return i;
        }
        return -1;
    }

}
