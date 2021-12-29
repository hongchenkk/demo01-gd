package com.godink.demo01.leetcode.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//定义一个二叉树节点
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
}
