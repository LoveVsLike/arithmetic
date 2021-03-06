package com.dream.arithmetic.temp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	
	//求二叉树的最大深度
	static int maxDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		
		return Math.max(left, right)+1;
	}
	
	//求二叉树的最小深度
	int getMinDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return getMin(root);
    }
	
    int getMin(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right)) + 1;
    }
    
    //求二叉树中节点的个数
    int numOfTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;
    }

    //求二叉树中叶子节点的个数
   static int numsOfNodeTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return numsOfNodeTreeNode(root.left)+numsOfNodeTreeNode(root.right);
    }

    //求二叉树中第k层节点的个数
   int numsOfkLevelTreeNode(TreeNode root,int k){
       if(root == null||k<1){
           return 0;
       }
       if(k==1){
           return 1;
       }
       int numsLeft = numsOfkLevelTreeNode(root.left,k-1);
       int numsRight = numsOfkLevelTreeNode(root.right,k-1);
       return numsLeft + numsRight;
   }
   
   //判断二叉树是否是平衡二叉树
   boolean isBalanced(TreeNode node){
       return maxDeath2(node)!=-1;
   }
   int maxDeath2(TreeNode node){
       if(node == null){
           return 0;
       }
       int left = maxDeath2(node.left);
       int right = maxDeath2(node.right);
       if(left==-1||right==-1||Math.abs(left-right)>1){
           return -1;
       }
       return Math.max(left, right) + 1;
   }
   
   //判断二叉树是否是完全二叉树
   boolean isCompleteTreeNode(TreeNode root){
       if(root == null){
           return false;
       }
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);
       boolean result = true;
       boolean hasNoChild = false;
       while(!queue.isEmpty()){
           TreeNode current = queue.remove();
           if(hasNoChild){
               if(current.left!=null||current.right!=null){
                   result = false;
                   break;
               }
           }else{
               if(current.left!=null&&current.right!=null){
                   queue.add(current.left);
                   queue.add(current.right);
               }else if(current.left!=null&&current.right==null){
                   queue.add(current.left);
                   hasNoChild = true;
               }else if(current.left==null&&current.right!=null){
                   result = false;
                   break;
               }else{
                   hasNoChild = true;
               }
           }
       }
       return result;
   }
   
   //两个二叉树是否完全相同
   boolean isSameTreeNode(TreeNode t1,TreeNode t2){
       if(t1==null&&t2==null){
           return true;
       }
       else if(t1==null||t2==null){
           return false;
       }
       if(t1.val != t2.val){
           return false;
       }
       boolean left = isSameTreeNode(t1.left,t2.left);
       boolean right = isSameTreeNode(t1.right,t2.right);
       return left&&right;
   }
   
   //两个二叉树是否互为镜像
   boolean isMirror(TreeNode t1,TreeNode t2){
       if(t1==null&&t2==null){
           return true;
       }
       if(t1==null||t2==null){
           return false;
       }
       if(t1.val != t2.val){
           return false;
       }
       return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
   }

   //翻转二叉树or镜像二叉树
   TreeNode mirrorTreeNode(TreeNode root){
       if(root == null){
           return null;
       }
       TreeNode left = mirrorTreeNode(root.left);
       TreeNode right = mirrorTreeNode(root.right);
       root.left = right;
       root.right = left;
       return root;
   }
   
   //求两个二叉树的最低公共祖先节点
   TreeNode getLastCommonParent(TreeNode root,TreeNode t1,TreeNode t2){
       if(findNode(root.left,t1)){
           if(findNode(root.right,t2)){
               return root;
           }else{
               return getLastCommonParent(root.left,t1,t2);
           }
       }else{
           if(findNode(root.left,t2)){
               return root;
           }else{
               return getLastCommonParent(root.right,t1,t2);
           }
       }
   }
   // 查找节点node是否在当前 二叉树中
   boolean findNode(TreeNode root,TreeNode node){
       if(root == null || node == null){
           return false;
       }
       if(root == node){
           return true;
       }
       boolean found = findNode(root.left,node);
       if(!found){
           found = findNode(root.right,node);
       }
       return found;
   }
   
   //二叉树的前序遍历
   ArrayList<Integer> preOrder(TreeNode root){
       Stack<TreeNode> stack = new Stack<TreeNode>();
       ArrayList<Integer> list = new ArrayList<Integer>();
       if(root == null){
           return list;
       }
       stack.push(root);
       while(!stack.empty()){
           TreeNode node = stack.pop();
           list.add(node.val);
           if(node.right!=null){
               stack.push(node.right);
           }
           if(node.left != null){
               stack.push(node.left);
           }
       }
       return list;
   }
   
   //递归解法
   ArrayList<Integer> preOrderReverse(TreeNode root){
       ArrayList<Integer> result = new ArrayList<Integer>();
       preOrder2(root,result);
       return result;
   }
   void preOrder2(TreeNode root,ArrayList<Integer> result){
       if(root == null){
           return;
       }
       result.add(root.val);
       preOrder2(root.left,result);
       preOrder2(root.right,result);
   }

   //二叉树的中序遍历
   ArrayList<Integer> inOrder(TreeNode root){
       ArrayList<Integer> list = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<TreeNode>();
       TreeNode current = root;
       while(current != null|| !stack.empty()){
           while(current != null){
               stack.add(current);
               current = current.left;
           }
           current = stack.peek();
           stack.pop();
           list.add(current.val);
           current = current.right;
       }
       return list;
   }
   
   //二叉树的后序遍历
   ArrayList<Integer> postOrder(TreeNode root){
       ArrayList<Integer> list = new ArrayList<Integer>();
       if(root == null){
           return list;
       }
       list.addAll(postOrder(root.left));
       list.addAll(postOrder(root.right));
       list.add(root.val);
       return list;
   }
   
   //前序遍历和后序遍历构造二叉树
   TreeNode buildTreeNode(int[] preorder,int[] inorder){
       if(preorder.length!=inorder.length){
           return null;
       }
       return myBuildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
   }

	TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
		if (instart > inend) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[prestart]);
		int position = findPosition(inorder, instart, inend, preorder[prestart]);
		root.left = myBuildTree(inorder, instart, position - 1, preorder, prestart + 1, prestart + position - instart);
		root.right = myBuildTree(inorder, position + 1, inend, preorder, position - inend + preend + 1, preend);
		return root;
	}
   int findPosition(int[] arr,int start,int end,int key){
       int i;
       for(i = start;i<=end;i++){
           if(arr[i] == key){
               return i;
           }
       }
       return -1;
   }
   
   //在二叉树中插入节点
   TreeNode insertNode(TreeNode root,TreeNode node){
       if(root == node){
           return node;
       }
       TreeNode tmp = new TreeNode();
       tmp = root;
       TreeNode last = null;
       while(tmp!=null){
           last = tmp;
           if(tmp.val>node.val){
               tmp = tmp.left;
           }else{
               tmp = tmp.right;
           }
       }
       if(last!=null){
           if(last.val>node.val){
               last.left = node;
           }else{
               last.right = node;
           }
       }
       return root;
   }
   
   //输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数所有的路径
   void findPath(TreeNode r,int i){
       if(r == null){
           return;
       }
       Stack<Integer> stack = new Stack<Integer>();
       int currentSum = 0;
       findPath(r, i, stack, currentSum);
   }
   void findPath(TreeNode r,int i,Stack<Integer> stack,int currentSum){
       currentSum+=r.val;
       stack.push(r.val);
       if(r.left==null&&r.right==null){
           if(currentSum==i){
               for(int path:stack){
                   System.out.println(path);
               }
           }
       }
       if(r.left!=null){
           findPath(r.left, i, stack, currentSum);
       }
       if(r.right!=null){
           findPath(r.right, i, stack, currentSum);
       }
       stack.pop();
   }
   
   //二叉树的搜索区间
   ArrayList<Integer> result;
   ArrayList<Integer> searchRange(TreeNode root,int k1,int k2){
       result = new ArrayList<Integer>();
       searchHelper(root,k1,k2);
       return result;
   }
   void searchHelper(TreeNode root,int k1,int k2){
       if(root == null){
           return;
       }
       if(root.val>k1){
           searchHelper(root.left,k1,k2);
       }
       if(root.val>=k1&&root.val<=k2){
           result.add(root.val);
       }
       if(root.val<k2){
           searchHelper(root.right,k1,k2);
       }
   }
   
   //二叉树的层次遍历
   ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if(root == null){
           return result;
       }
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.offer(root);
       while(!queue.isEmpty()){
           int size = queue.size();
           ArrayList<Integer> level = new ArrayList<Integer>();
           for(int i = 0;i < size ;i++){
               TreeNode node = queue.poll();
               level.add(node.val);
               if(node.left != null){
                   queue.offer(node.left);
               }
               if(node.right != null){
                   queue.offer(node.right);
               }
           } 
           result.add(level);
       }
       return result;
   }
   
   //二叉树内两个节点的最长距离
   /**
    * 二叉树中两个节点的最长距离可能有三种情况：
1.左子树的最大深度+右子树的最大深度为二叉树的最长距离
2.左子树中的最长距离即为二叉树的最长距离
3.右子树种的最长距离即为二叉树的最长距离
因此，递归求解即可
    * @param args
    */
   private static class Result{  
	    int maxDistance;  
	    int maxDepth;  
	    public Result() {  
	    }  
	    public Result(int maxDistance, int maxDepth) {  
	        this.maxDistance = maxDistance;  
	        this.maxDepth = maxDepth;  
	    }  
	}  
	    int getMaxDistance(TreeNode root){
	      return getMaxDistanceResult(root).maxDistance;
	    }
	    Result getMaxDistanceResult(TreeNode root){
	        if(root == null){
	            Result empty = new Result(0,-1);
	            return empty;
	        }
	        Result lmd = getMaxDistanceResult(root.left);
	        Result rmd = getMaxDistanceResult(root.right);
	        Result result = new Result();
	        result.maxDepth = Math.max(lmd.maxDepth,rmd.maxDepth) + 1;
	        result.maxDistance = Math.max(lmd.maxDepth + rmd.maxDepth,Math.max(lmd.maxDistance,rmd.maxDistance));
	        return result;
	    }
   
   /**
    * 不同的二叉树
    * 给出 n，问由 1…n 为节点组成的不同的二叉查找树有多少种？
    * @param args
    */
	    int numTrees(int n ){
	        int[] counts = new int[n+2];
	        counts[0] = 1;
	        counts[1] = 1;
	        for(int i = 2;i<=n;i++){
	            for(int j = 0;j<i;j++){
	                counts[i] += counts[j] * counts[i-j-1];
	            }
	        }
	        return counts[n];
	    }
	    
	    
	    /**
	     * 判断二叉树是否是合法的二叉查找树(BST)
	     * 一棵BST定义为：
节点的左子树中的值要严格小于该节点的值。
节点的右子树中的值要严格大于该节点的值。
左右子树也必须是二叉查找树。
一个节点的树也是二叉查找树。
	     * @param args
	     */
	    public int lastVal = Integer.MAX_VALUE;
	    public boolean firstNode = true;

	public boolean isValidBST(TreeNode root) {
		// write your code here
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (!firstNode && lastVal >= root.val) {
			return false;
		}
		firstNode = false;
		lastVal = root.val;
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
	}
   
   
   
   
   
	public static void main(String[] args) {
		TreeNode n20 = new TreeNode();
		TreeNode n18 = new TreeNode();
		TreeNode n19 = new TreeNode();
		TreeNode n22 = new TreeNode();
		TreeNode n21 = new TreeNode();
		TreeNode n23 = new TreeNode();
		TreeNode n26 = new TreeNode();
		n20.val = 20;
		n20.left = n18;
		n20.right = n22;
		
		n18.val = 18;
		n18.right = n19;
		
		n19.val = 19;
		
		n22.val =22;
		n22.left = n21;
		n22.right = n23;
		
		n23.val = 23;
		n23.right = n26;
		
		n26.val = 26;
		System.out.println(numsOfNodeTreeNode(n20));
	}
	
}
