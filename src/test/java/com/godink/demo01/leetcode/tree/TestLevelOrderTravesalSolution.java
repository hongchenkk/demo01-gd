package com.godink.demo01.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层级遍历二叉树
 * @ClassName: TestLevelOrderTravesalSolution 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年12月22日 上午9:56:44
 */
public class TestLevelOrderTravesalSolution {
	
	/**
	 * 利用队列来层级遍历二叉树
	 * TODO 
	 * @author Hong.Chen
	 * @date 2021-12-22 10:30:29  
	 * @param root
	 * @return 
	 * @return List<List<Integer>>
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		//用于存放待遍历的节点
		Queue<TreeNode> queue = new LinkedList<>();
		//用于存放所有的结果
		List<List<Integer>> wrapList = new LinkedList<>();
		//首先将根节点放入队列，进行遍历开始
		queue.offer(root);
		//循环遍历队列
		while (!queue.isEmpty()) {
			//用于存放当前队列的节点值，这就是当前层的所有节点值
			List<Integer> subList = new LinkedList<>();
			//对该队列进行遍历
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				//将左节点加入队列，以便while循环对下一层继续
				if(queue.peek().getLeft() != null) {
					queue.offer(queue.peek().getLeft());
				}
				//将右节点加入度列，以便while循环对下一层继续
				if(queue.peek().getRight() != null) {
					queue.offer(queue.peek().getRight());
				}
				//将当前节点的值加入到子列表
				subList.add(queue.poll().getVal());
			}
			//将子列表加入到返回列表
			wrapList.add(subList);
		}
		return wrapList;
	}
	

	public static void main(String[] args) {
		//构造一颗树
		TreeNode root = new TreeNode(3, null, null);
		TreeNode left = new TreeNode(9, null, null);
		TreeNode right = new TreeNode(20, null, null);
		TreeNode lright = new TreeNode(15, null, null);
		TreeNode rright = new TreeNode(7, null, null);
		//关联节点
		root.left = left;
		root.right = right;
		right.left = lright;
		right.right = rright;
		
		//测试通过队列层级遍历该二叉树
		List<List<Integer>> levelOrder = new TestLevelOrderTravesalSolution().levelOrder(root);
		System.out.println(levelOrder);
	}
}
