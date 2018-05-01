package com.dream.arithmetic.seek;

import java.util.Arrays;

public class Test {
	
 public int forEach(int n) {
	 int result = 0;
	 for(int i = 0; i <=n; i++) {
		 result+=i;
	 }
	 
	 return result;
 }
 
 public static int[] sort(int[] array) {
	 for(int i = 0; i < array.length;i++) {
		 for(int j = i+1; j < array.length-1;j++) {
			 if(array[i] < array[j]) {
				 int temp = array[i];
				 array[i] = array[j];
				 array[j]=temp;
			 }
		 }
	 }
	 
	 return array;
 }
 
 public int recursion(int n) {
	 if(n == 1) {
		 return n;
	 }else {
		 return n + recursion(n-1);
	 }
 }
 
 public int as(int n) {
	 return (1+n)*n/2;
 }
	
	
public static void main(String[] args) {
	int[] x = {6,5,4,7,3};
	 System.out.println(Arrays.toString(sort(x)));
   }

}
