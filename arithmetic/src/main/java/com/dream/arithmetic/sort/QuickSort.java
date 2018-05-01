package com.dream.arithmetic.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static int[] sort(int[] array,int left,int right) {
		if(left < right) {
			int povit = partiton(array,left,right);
			sort(array,left,povit-1);
			sort(array,povit+1,right);
		}
		
		return array;
	}
	
	private static int partiton(int[] array, int left, int right) {
		int povit = array[left];
		while(left < right) {
			while(left < right && povit <= array[right]) {
				right--;
			}
			
			if(left < right) {
				array[left++] = array[right];
			}
			
			while(left < right && povit >= array[left] ) {
				left++;
			}
			
			if(left < right) {
				array[right--] = array[left];
			}
		}
		
		array[left] = povit;
		return left;
	}

	public static void main(String[] args) {
		int x[] = {2,6,3,8,45,3};
		System.out.println(Arrays.toString(sort(x,0,x.length-1)));
	}

}
