package com.dream.arithmetic.sort;

import java.util.Arrays;

public class ShellSort {
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int[] sort(int[] array) {
		int step = array.length/2;
		while(step >= 1) {
			for(int i = step; i < array.length;i++) {
				int j = 0;
				int temp = array[i];
				for(j = i-step; j >= 0 && temp < array[j];j = j-step ) {
					array[j+step] = array[j];
				}
				array[j+step] = temp;
			}
			step = step/2;
		}
		
		return array;
	}

	public static void main(String[] args) {
		int x[] = {2,6,3,8,45,3};
		System.out.println(Arrays.toString(sort(x)));
	}

}
