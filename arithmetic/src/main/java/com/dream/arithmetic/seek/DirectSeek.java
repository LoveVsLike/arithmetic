package com.dream.arithmetic.seek;

/**
 * 直接查找算法：
 *   没有查到返回-1；否则返回数组对于的编号
 * @author dream
 *
 */
public class DirectSeek {
	
	public static int sort(int[] array, int target) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == target) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int whileSort(int[] array, int target) {
		int i = array.length-1;
		if(array[0] == target){
			return 0;
		}
		array[0] = target;
		while(array[i] != target) {
			i--;
		}
		
		return i > 0?i:-1;
	}
	
	public static void main(String[] args) {
		int[] array = { 6, 5, 7, 3, 2, 8 };
		System.out.println(whileSort(array, 8));
	}

}
