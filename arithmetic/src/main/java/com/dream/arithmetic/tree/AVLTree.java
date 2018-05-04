package com.dream.arithmetic.tree;

public class AVLTree<T extends Comparable<T>> {
	public AVLNode<T> root;

	public AVLTree(AVLNode<T> root) {
		this.root = root;
	}

	public void insert(T data) {
		this.root = insert(root, data);
	}

	private AVLNode<T> insert(AVLNode<T> node, T data) {
		if (node == null) {
			node = new AVLNode<T>(data);
		}

		int compare = data.compareTo(node.getData());
		if (compare < 0) {// 向左插入数据 data 小于 node
			node.left = insert(node.left, data);
			if (height(node.left) - height(node.right) == 2) {
				if (data.compareTo(node.left.data) < 0) {
					node = reverseLeft(node);
				} else {
					node = reverseDoubleLeft(node);
				}
			}
		} else if (compare > 0) {// 向右插入数据
			node.right = insert(node.right, data);
			if (height(node.right) - height(node.left) == 2) {
				if (data.compareTo(node.right.data) < 0) {
					node = reverseDoubleRight(node);
				} else {
					node = reverseRight(node);
				}
			}
		}

		node.high = Math.max(height(node.left), height(node.right)) + 1;

		return node;
	}

	private int height(AVLNode<T> node) {
		return node != null ? node.high : 0;
	}

	// LL
	private AVLNode<T> reverseLeft(AVLNode<T> node) {
		AVLNode<T> w = node.left;
		node.left = w.right;
		w.right = node;
		node.high = node.high - 1;
		w.high = w.high + 1;

		return w;
	}

	// RR
	private AVLNode<T> reverseRight(AVLNode<T> node) {
		AVLNode<T> x = node.right;
		node.right = x.left;
		x.left = node;
		node.high = x.high;
		x.high = x.high + 1;

		return x;
	}

	// LR
	private AVLNode<T> reverseDoubleLeft(AVLNode<T> node) {
		node.left = reverseRight(node.left);
		return reverseLeft(node);
	}

	// RL
	private AVLNode<T> reverseDoubleRight(AVLNode<T> node) {
		node.left = reverseLeft(node.left);
		return reverseRight(node);
	}

	public void remove(T data) {
		if (data == null) {
			return;
		}
		this.root = remove(root, data);
	}

	/**
	 * 删除一个节点的主要步骤如下所示：
	 * 	1. 如果是null节点，则直接返回null
	 * 	2. 如果删除的值<当前节点，则转入left节点进行递归删除
	 * 	3. 如果删除的值>当前节点，则转入right节点进行递归删除
	 * 	4. 如果删除的值为当前节点，如果当前节点只有一个子树，则直接返回该子树
	 * 	5. 如果删除的值为当前节点，且当前节点有两个子树，则将当前值更改为右子树中最小的节点值，并递归在右子树中删除该节点值
	 *	6. 重新修正该处理节点的height值
	 * 	7. 对处理节点进行重新翻转处理，以修正在删除过程中可能出现的树不平衡情况
	 * 
	 */
	private AVLNode<T> remove(AVLNode<T> node, T data) {
		if (node == null)	// 第1步
			return null;
		int cmp = data.compareTo(node.data);
		if (cmp < 0) {// 第2步
			node.left = remove(node.left,data);
		} else if (cmp > 0) {// 第3步
			node.right = remove(node.right,data);
		} else if (node.left != null && node.right != null) {// 第5步
			node.data = findMin(node.right);
			node.right = remove(node.right, node.data);
		} else {// 第4步
			node = node.left == null ? node.right : node.left;
		}
		
		if (node != null)// 第6步
			node.high = Math.max(height(node.left), height(node.right)) + 1;
		node = rotate(node);// 第7步
		return node;
	}
	
	private T findMin(AVLNode<T> right) {
		if(right.left == null) {
			return right.data;
		}
		
		return findMin(right.left);
	}
	
	private T findMax(AVLNode<T> right) {
		if(right.right == null) {
			return right.data;
		}
		
		return findMin(right.right);
	}
	
	private AVLNode<T> remove1(AVLNode<T> tree, T data) {
	    if (tree==null)
	        return null;
	    int cmp = data.compareTo(tree.data);
	    if (cmp < 0) {
	        tree.left = remove(tree.left, data);
	        if (height(tree.right) - height(tree.left) == 2) {
	            AVLNode<T> r =  tree.right;
	            if (height(r.left) > height(r.right))
	                tree = reverseDoubleRight(tree);
	            else
	                tree = reverseRight(tree);
	        }
	    } else if (cmp > 0) {
	        tree.right = remove(tree.right, data);
	        if (height(tree.left) - height(tree.right) == 2) {
	            AVLNode<T> l =  tree.left;
	            if (height(l.right) > height(l.left))
	                tree = reverseDoubleLeft(tree);
	            else
	                tree = reverseLeft(tree);
	        }
	    } else {
	        if ((tree.left!=null) && (tree.right!=null)) {
	            if (height(tree.left) > height(tree.right)) {
	                tree.data = findMax(tree.left);
	                tree.left = remove(tree.left, tree.data);
	            } else {
	                tree.data = findMin(tree.right);
	                tree.right = remove(tree.right, data);
	            }
	        } else {
	            tree = (tree.left!=null) ? tree.left : tree.right;
	        }
	    }
	    
	    return tree;
	}

	private AVLNode<T> rotate(AVLNode<T> node) {
        if(node == null)
            return null;
        if(height(node.left) - height(node.right) == 2) {
            if(height(node.left.left) >= height(node.left.right))
                return reverseDoubleLeft(node);
            else
                return reverseLeft(node);
        } else if(height(node.right) - height(node.left) == 2) {
            if(height(node.right.right) >= height(node.right.left))
                return reverseRight(node);
            else
                return reverseDoubleRight(node);
        }
        return node;
    }

}
