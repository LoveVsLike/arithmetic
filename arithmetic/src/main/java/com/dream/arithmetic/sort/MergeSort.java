package com.dream.arithmetic.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] sort(int[] array, int low,int high) {
		int mid = (low+high)/2;
		if(low < high) {
			sort(array,low,mid);
			sort(array,mid+1,high);
			merge(array,low,mid,high);
		}
		
		return array;
	}

	private static void merge(int[] array, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int k = 0;
		int j = mid + 1;
		while (i <= mid && j <= high) {
			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = array[i++];
		}

		while (j <= high) {
			temp[k++] = array[j++];
		}

		for (int m = 0; m < temp.length; m++) {
			array[m + low] = temp[m];
		}

	}
	
	public static void main(String[] args) {
		int x[] = {2,6,3,8,45,3};
		System.out.println(Arrays.toString(sort(x,0,x.length-1)));
	}

}
