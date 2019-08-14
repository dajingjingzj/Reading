package com.atzj.leecode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 之字形打印二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 用栈的特性来帮助实现之字形顺序，不用遇到偶数层就reverse
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>();  //存奇数层节点
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<>(); //存偶数层节点

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp1 = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp1.add(node.val);
                        System.out.println(node.val + "");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp1.isEmpty()) {
                    lists.add(temp1);
                    layer++;
                    System.out.println();
                }
            }else {
                    ArrayList<Integer> temp2 = new ArrayList<>();
                    while (!s2.empty()) {
                        TreeNode node = s2.pop();
                        if (node != null) {
                            temp2.add(node.val);
                            System.out.println(node.val + "");
                            s1.push(node.right);
                            s1.push(node.left);
                        }
                    }
                    if (!temp2.isEmpty()) {
                        lists.add(temp2);
                        layer++;
                        System.out.println();
                    }
                }
            }
        return lists;
    }
}
