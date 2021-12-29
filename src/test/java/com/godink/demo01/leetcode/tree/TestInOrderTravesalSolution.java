package com.godink.demo01.leetcode.tree;

import static org.mockito.Mockito.inOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 * @ClassName: TestInOrderTravesalSolution 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月21日 上午11:38:24
 */
public class TestInOrderTravesalSolution {

	/**
	 * 用递归的方式来中序遍历二叉树
	 * 每次递归调用都放回一个列表
	 * TODO 
	 * @author Hong.Chen
	 * @date 2021-12-21 11:39:12  
	 * @param root
	 * @return 
	 * @return List<Integer>
	 */
	public List<Integer> inOrderTravesalSolution(TreeNode root) {
		//乘放节点值的列表
		List<Integer> result = new ArrayList<>();
		
		//递归框架模型:
		//递归出口
		if(root == null) {
			return result;
		}
		//递归体
		//二叉树中序遍历框架模型：
		//访问左节点
		List<Integer> leftResult = inOrderTravesalSolution(root.left);
		result.addAll(leftResult);
		//访问根节点
		result.add(root.getVal());
		//访问右节点
		List<Integer> rightResult = inOrderTravesalSolution(root.right);
		result.addAll(rightResult);
		
		return result;
	}
	
	/**
	 * 递归中序遍历二叉树-优化版：无需每次递归都生成一个list
	 * 共用一个list
	 * TODO 
	 * @author Hong.Chen
	 * @date 2021-12-21 14:11:38  
	 * @param root
	 * @return 
	 * @return List<Integer>
	 */
	public List<Integer> inOrderTravesalSolutionOptimization(TreeNode root) {
		//存放节点值的列表
		List<Integer> result = new LinkedList<>();
		//调用递归函数
		inOrderHelper(root, result);
		//返回列表
		return result;
	}
	
	//被递归调用的函数
	//result: 是引用进来包含节点值的
	public void inOrderHelper(TreeNode root, List<Integer> result) {
		//递归出口
		if(root == null) {
			return;
		}
		//递归体
		//中序遍历框架模型
		//访问左节点
		inOrderHelper(root.left, result);
		//访问根节点
		result.add(root.getVal());
		//访问右节点
		inOrderHelper(root.right, result);
	}
	
	public static void main(String[] args) {
		//构造一颗二叉树[1,null,2,3]
		TreeNode root = new TreeNode(1, null , null);
		TreeNode right = new TreeNode(2, null , null);
		TreeNode rleft = new TreeNode(3, null , null);
		//关联节点
		root.right = right;
		right.left = rleft;
		
		//递归-非优化方式-中序遍历节点
		List<Integer> inOrderTravesalSolution = new TestInOrderTravesalSolution().inOrderTravesalSolution(root);
		System.out.println(inOrderTravesalSolution);
		
		//递归-优化方式-中序遍历节点
		List<Integer> inOrderTravesalSolutionOptimization = new TestInOrderTravesalSolution().inOrderTravesalSolutionOptimization(root);
		System.out.println(inOrderTravesalSolutionOptimization);
	}
}
