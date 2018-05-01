package com.dream.arithmetic.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieTree {
	public TrieNode root;

	public TrieTree() {
		root = new TrieNode();
	}

	// 插入一个单词
	public void insert(String word) {
		TrieNode current = root;
		char[] data = word.toLowerCase().toCharArray();
		for (int i = 0; i < data.length; i++) {
			int index = data[i] - 'a';
			if (current.children[index] == null) {
				current.children[index] = new TrieNode(data[i]);
			}
			current = current.children[index];
			current.prefixNum++;
		}
		current.isLeaf = true;
		current.frequency++;
	}

	// 寻找是否存在某个单词
	public boolean search(String word) {
		TrieNode cur = root;
		char[] data = word.toLowerCase().toCharArray();
		for (int i = 0; i < data.length; i++) {
			int index = data[i] - 'a';
			if (cur.children[index] == null) {
				return false;
			}
			cur = cur.children[index];
		}
		
		return cur.isLeaf;
	}

	// 查找是否有以某个字符串为开头的单词
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		char[] data = prefix.toLowerCase().toCharArray();
		for (int i = 0; i < data.length; i++) {
			int index = data[i] - 'a';
			if (cur.children[index] == null) {
				return false;
			}
			cur = cur.children[index];
		}
		return true;
	}

	/*
	 * 得到所有单词及出现次数
	 */
	public Map<String, Integer> getAllwords() {
		return helper(root, "");
	}

	private Map<String, Integer> helper(TrieNode cur, String s) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		if (cur != null) {
			if (cur.isLeaf == true) {
				hashMap.put(s, cur.frequency);
			}
		}
		for (int i = 0; i < cur.children.length; i++) {
			if (cur.children[i] != null) {
				String tmp = s + (char) (i + 'a');
				hashMap.putAll(helper(cur.children[i], tmp));
			}
		}
		return hashMap;
	}

	/*
	 * 得到以某字串为前缀的字串集，包括字串本身！
	 */
	public Map<String, Integer> getWordsForPrefix(String prefix) {
		return getWordsForPrefix(root, prefix);
	}

	private Map<String, Integer> getWordsForPrefix(TrieNode cur, String prefix) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		char[] data = prefix.toLowerCase().toCharArray();
		for (int i = 0; i < data.length; i++) {
			if (cur.children[data[i] - 'a'] == null) {
				return hashMap;
			}
			cur = cur.children[data[i] - 'a'];
		}
		return helper(cur, prefix);
	}
}
