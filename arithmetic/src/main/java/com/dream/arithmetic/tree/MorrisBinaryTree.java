package com.dream.arithmetic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/yangfeisc/article/details/45673947
 * @author admin
 *
 */
public class MorrisBinaryTree {

	/**
	 * 前序遍历：根左右 ; 1. 如果当前节点的左子节点为空时，输出当前节点，并将当前节点置为该节点的右子节点；
	 * 2.如果当前节点的左子节点不为空，找到当前节点左子树的最右节点（该节点为当前节点中序遍历的前驱节点）；
	 * 2.1.如果最右节点的右指针为空(right=null)，将最右节点的右指针指向当前节点，并输出当前节点（在此处输出），当前节点置为其左子节点；
	 * 2.2.如果最右节点的右指针不为空，将最右节点右指针重新置为空(恢复树的原状)，并将当前节点置为其右节点； 3. 重复1~2，直到当前节点为空。
	 */
	public List<Integer> preorder(BinaryNode node) {
		List<Integer> result = new ArrayList<>();
		if (node == null)
			return result;
		BinaryNode current = node;
		while (current != null) {
			if (current.left == null) {
				result.add(current.data);
				current = current.right;
			} else {
				BinaryNode temp = current.left;
				while (temp.right != null && temp.right != current)
					temp = temp.right;
				if (temp.right == null) {
					result.add(current.data); // 输出当前节点
					temp.right = current; // 找到当前节点的前驱节点
					current = current.left;
				} else {
					temp.right = null; // 恢复二叉树
					current = current.right;
				}
			}
		}
		
		return result;
	}

	// 中序遍历：左根右
	public List<Integer> inorder(BinaryNode node) {
		 List<Integer> result = new ArrayList<>();  
		    if(node == null)  
		        return result;  
		    BinaryNode current = node;  
		    while(current != null) {  
		        if(current.left == null) {  
		            result.add(current.data);  
		            current = current.right;  
		        } else {  
		        	BinaryNode temp = current.left;  
		            while(temp.right != null && temp.right != current)  
		                temp = temp.right;  
		            if(temp.right == null) {  
		                temp.right = current;  //找到当前节点的前驱节点  
		                current = current.left;  
		            } else {  
		                result.add(current.data);  
		                temp.right = null;  //恢复二叉树  
		                current = current.right;  
		            }  
		        }  
		    }  
		    return result;  
	}

	// 后续遍历: 左右根
	public List<Integer> postorder(BinaryNode node) {
		 List<Integer> result = new ArrayList<>();  
		    if(node == null)  
		        return result;  
		    BinaryNode current = node;  
		    while(current != null) {  
		        if(current.left == null) {  
		            result.add(current.data);  
		            current = current.right;  
		        } else {  
		        	BinaryNode temp = current.left;  
		            while(temp.right != null && temp.right != current)  
		                temp = temp.right;  
		            if(temp.right == null) {  
		                result.add(current.data); //输出当前节点  
		                temp.right = current;  //找到当前节点的前驱节点  
		                current = current.left;  
		            } else {  
		                temp.right = null;  //恢复二叉树  
		                current = current.right;  
		            }  
		        }  
		    }  
		    return result;  
	}

}
