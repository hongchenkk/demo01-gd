package com.godink.demo01.leetcode.tree;

/**
 * 用递归求取二叉树的最大深度
 * @ClassName: TestMaxDepthTree 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月22日 上午11:49:49
 */
public class TestMaxDepthTree {
	
	int maxDepth1 = 0;

	/**
	 * 假设根节点的深度为1
	 * @author Hong.Chen
	 * @date 2021-12-22 11:50:40  
	 * @param root 
	 * @return int
	 */
	public int maxDepthTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		maxHelper(root, 1);
		return maxDepth1;
	}
	
	public void maxHelper(TreeNode root, int depth) {
		//递归出口
		if(root == null) {
			return;
		}
		//递归体
		//二叉树自上而下的模型，其实就是前序遍历框架模型
		//访问根节点：判断该节点是否为叶子节点，如果是，则更新最大值
		if(root.left == null && root.right == null) {
			//System.out.println(maxDepth1);
			maxDepth1 = Math.max(depth, maxDepth1);
		}
		//访问左节点
		maxHelper(root.left, depth+1);
		//访问右节点
		maxHelper(root.right, depth+1);
	}
	
	/**
	 * 优化版
	 * TODO 
	 * @author Hong.Chen
	 * @date 2021-12-22 14:33:01  
	 * @param root
	 * @return 
	 * @return int
	 */
	public int maxOpitimaztion(TreeNode root) {
		
//        if(root == null) return 0;
//        
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        return Math.max(left, right) + 1;
		
		if(root == null) {
			return 0;
		}
		return 1+Math.max(maxOpitimaztion(root.left), maxOpitimaztion(root.right));
	}
	
	public static void main(String[] args) {
		//构造一颗树
		TreeNode root = new TreeNode(3, null, null);
		TreeNode left = new TreeNode(9, null, null);
		TreeNode right = new TreeNode(20, null, null);
		TreeNode rl = new TreeNode(15, null, null);
		TreeNode rr = new TreeNode(7, null, null);
		//关联节点
		root.left = left;
		root.right = right;
		right.left = rl;
		right.right = rr;
		
		//求取该树的最大深度
		int maxDepthTree = new TestMaxDepthTree().maxDepthTree(root);
		System.out.println("result1:" + maxDepthTree);
		
		//优化版-求取该树的最大深度
		int maxOpitimaztion = new TestMaxDepthTree().maxOpitimaztion(root);
		System.out.println("result2:" + maxOpitimaztion);
	}
}
