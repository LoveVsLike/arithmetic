package com.dream.arithmetic.leetcode;

import java.util.Stack;

public class Solution {

	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		for (String item : tokens) {
			if ("+".equals(item)) {
				Integer num1 = Integer.valueOf(stack.pop());
				Integer num2 = Integer.valueOf(stack.pop());
				stack.push(num1+num2 +"");
			} else if ("-".equals(item)) {
				Integer num1 = Integer.valueOf(stack.pop());
				Integer num2 = Integer.valueOf(stack.pop());
				stack.push(num2-num1 +"");
			} else if ("*".equals(item)) {
				Integer num1 = Integer.valueOf(stack.pop());
				Integer num2 = Integer.valueOf(stack.pop());
				stack.push(num2*num1 +"");
			} else if ("/".equals(item)) {
				Integer num1 = Integer.valueOf(stack.pop());
				Integer num2 = Integer.valueOf(stack.pop());
				stack.push(num2/num1 +"");
			}

			stack.push(item);
		}
		
		return Integer.valueOf(stack.pop());
	}

	public static void main(String[] args) {

	}

}
