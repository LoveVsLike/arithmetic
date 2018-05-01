package com.dream.arithmetic.sort;

import java.util.Arrays;

public class InsertSort {
	
	/**
	 * 插入排序是根据第一个元素开始插入，然后比较已经插入元素的
	 * @param array
	 * @return
	 */
	public static int[] sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = 0;
			for (j = i - 1; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
		
		return array;
	}
	
	
	public static void main(String[] args) {
		int x[] = {2,6,3,8,45,3};
		System.out.println(Arrays.toString(sort(x)));
	}

}
