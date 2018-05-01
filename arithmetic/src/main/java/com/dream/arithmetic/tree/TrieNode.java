package com.dream.arithmetic.tree;

public class TrieNode {
	TrieNode[] children = new TrieNode[26];
	
	char value;    //可以没有，数组下标可以知道val值
	int frequency; //该字串的重复数目,频数
	int prefixNum; //以该子串为前缀的单词数
	boolean isLeaf;

	public TrieNode() {
		// TODO Auto-generated constructor stub
	}

	public TrieNode(char value) {
		this.value = value;
		isLeaf = false;
	}

}
