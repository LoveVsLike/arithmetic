package com.dream.arithmetic.sort;

import java.util.Arrays;

//FIXME
public class BubbleSort {
	
	public static int[] sort(int[] data, int left,int right) {
		while(left < (right = bubble(data, left, right)));
		return data;
	}

	private static int bubble(int[] data, int left, int right) {
		int last = left;
		while(++left < right){
			if(data[left-1] > data[left]) {
				last = left;
				swap(data, data[left-1], data[left]);
			}
		}
		return last;
	}

	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
	
	public static void main(String[] args) {
		int[] array = {2,6,8,1,3,5,9};
		System.out.println(Arrays.toString(sort(array ,0,array.length-1)));
	}

}
