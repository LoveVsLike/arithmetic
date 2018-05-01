package com.dream.arithmetic.seek;

public class InterpolationSeek {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5, 6 };// 必须有序
		int index = seek(num, 5);
		System.out.print(index);
	}

	/*
	 * num：有序表（由小到大排列） key：要查找的关键字 return：还回查找到关键字的下标，没有找到则还回-1
	 */
	private static int seek(int[] num, int key) {
		int low, high, mid;
		low = 0;
		high = num.length - 1;
		while (low <= high) {
			// mid = (low + high) / 2;//二分查找
			mid = low + (high - low) * (key - num[low]) / (num[high] - num[low]); // 插值查找
			if (key < num[mid])
				high = mid - 1;
			else if (key > num[mid])
				low = mid + 1;
			else
				// 如果等于则直接还回下标值
				return mid;
		}
		return -1;
	}

}
