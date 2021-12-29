package com.godink.demo01.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 后序遍历访问二叉树
 * 既先访问左子树，再访问右子树，最后才是根节点
 * @ClassName: TestPostOrderTravesalSolution 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月21日 下午2:28:41
 */
public class TestPostOrderTravesalSolution {

	/**
	 * 递归-非优化的中序遍历二叉树
	 * TODO 
	 * @author Hong.Chen
	 * @date 2021-12-21 14:30:03  
	 * @param root
	 * @return 
	 * @return List<Integer>
	 */
	public List<Integer> postOrderTravesalSolution(TreeNode root) {
		//存放节点值的列表
		List<Integer> result = new LinkedList<>();
		//递归出口
		if(root == null) {
			return result;
		}
		//递归体
		//后序遍历二叉树框架模型
		//访问左节点
		List<Integer> leftResult = postOrderTravesalSolution(root.getLeft());
		result.addAll(leftResult);
		//访问右节点
		List<Integer> rightResult = postOrderTravesalSolution(root.getRight());
		result.addAll(rightResult);
		//访问根节点
		result.add(root.getVal());
		//返回列表
		return result;
	}
	
	public static void main(String[] args) {
		//构造一颗二叉树[1,null,2,3]
		TreeNode root = new TreeNode(1, null , null);
		TreeNode right = new TreeNode(2, null , null);
		TreeNode rleft = new TreeNode(3, null , null);
		//关联节点
		root.right = right;
		right.left = rleft;
		
		List<Integer> postOrderTravesalSolution = new TestPostOrderTravesalSolution().postOrderTravesalSolution(root);
		System.out.println(postOrderTravesalSolution);
	}
}
