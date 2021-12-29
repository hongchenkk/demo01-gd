package com.godink.demo01.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历二叉树
 * @ClassName: TestPreOrderTraversalSolution 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月21日 上午10:15:08
 */
public class TestPreOrderTraversalSolution {

	/**
	 * 用递归来前序遍历
	 * @author Hong.Chen
	 * @date 2021-12-21 10:17:52  
	 * @param root: 根节点
	 * @return 
	 * @return List<Integer>: 获取每个节点的值，都放在这个列表中
	 */
	public List<Integer> solutionWithRecursive(TreeNode root)	{
		List<Integer> preList = new LinkedList<>();
		//每次都返回一个新的列表
		//递归退出条件：当节点为null时返回列表
		if(root == null) {
			return preList;
		}
		//递归表达式
		//前序遍历：先遍历根节点，在左节点，在右节点
		//访问根节点
		preList.add(root.val);//将节点值放入列表
		//访问左节点
		List<Integer> leftList = solutionWithRecursive(root.left);
		preList.addAll(leftList);
		//访问右节点
		List<Integer> rightList = solutionWithRecursive(root.right);
		preList.addAll(rightList);
		return preList;
	}
	
	/**
	 * 优化版：只new一个列表，无需每次递归调用都new一个
	 * TODO 
	 * @author Hong.Chen
	 * @date 2021-12-21 11:04:14  
	 * @param root
	 * @return 
	 * @return List<Integer>
	 */
	public List<Integer> solutionWithRecursiveOptimiza(TreeNode root)	{
		//用于存放节点值的列表
		List<Integer> result = new ArrayList<>();
		//将迭代逻辑放到子方法中
		preHelper(root, result);
		return result;
	}
	
	public void preHelper(TreeNode root, List<Integer> result) {
		//以下就是递归的框架：首先递推出口，然后才是递归体
		//递归出口
		if(root == null) {
			return;
		}
		//递归体
		//前序遍历框架: 以下就是前序遍历的框架
		//访问根节点
		result.add(root.val);
		//访问左节点
		preHelper(root.left, result);
		//访问右节点
		preHelper(root.right, result);
	}
	
	/**
	 * 用栈来迭代: 栈中都放将要访问的节点，结合while来进行迭代
	 * TODO 
	 * @author Hong.Chen
	 * @date 2021-12-21 11:15:02  
	 * @param root
	 * @return 
	 * @return List<Integer>
	 */
	public List<Integer> solutionWithStack(TreeNode root) {
		//存放节点数据的列表
		List<Integer> result = new LinkedList<>();
		//如果根节点为空，则返回
		if(root == null) {
			return result;
		}
		//存放将要访问的节点
		Stack<TreeNode> tovisit = new Stack<>();
		//首先访问根节点
		tovisit.push(root);
		//循环访问栈中的节点
		while (!tovisit.isEmpty()) {//从栈顶往下访问
			//二叉树的前序遍历框架模型：
			//访问根节点
			TreeNode visiting = tovisit.pop();
			result.add(visiting.getVal());
			//这里由于栈的特性，先进后出，所以先压入右节点，让右节点后访问
			//访问右节点：通过放入栈中，后续通过循环触发访问
			if(visiting.right != null) {
				tovisit.push(visiting.right);
			}
			//访问左节点：通过放入栈中，后续通过循环触发访问
			if(visiting.left != null) {
				tovisit.push(visiting.left);
			}
		}
		return result;
//		List<Integer> pre = new LinkedList<Integer>();
//		if(root==null) return pre;
//		Stack<TreeNode> tovisit = new Stack<TreeNode>();
//		tovisit.push(root);
//		while(!tovisit.empty()) {
//			TreeNode visiting = tovisit.pop();
//			pre.add(visiting.val);
//			if(visiting.right!=null) tovisit.push(visiting.right);
//			if(visiting.left!=null) tovisit.push(visiting.left);
//		}
//		return pre;
	}
	
	public static void main(String[] args) {
		//构造一颗二叉树
		TreeNode root = new TreeNode(1, null, null);
		TreeNode left = new TreeNode(2, null, null);
		TreeNode lleft = new TreeNode(5, null, null);
		TreeNode right = new TreeNode(3, null, null);
		//关联节点
		root.left = left;
		root.right = right;
		left.left = lleft;
		
		//前序遍历节点，返回列表
		List<Integer> solutionWithRecursive = new TestPreOrderTraversalSolution().solutionWithRecursive(root);
		System.out.println(solutionWithRecursive);
		
		//前序遍历节点-优化版，返回列表
		List<Integer> solutionWithRecursiveOptimiza = new TestPreOrderTraversalSolution().solutionWithRecursiveOptimiza(root);
		System.out.println(solutionWithRecursiveOptimiza);
		
		//前序遍历节点-栈，返回列表
		List<Integer> solutionWithStack = new TestPreOrderTraversalSolution().solutionWithStack(root);
		System.out.println(solutionWithStack);
	}
}
