package com.atzj.leecode;

import java.util.Stack;

/**
 * 类描述：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @author zhoujing129
 */
public class 二叉搜索树的第k个结点 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
     *  所以，按照中序遍历顺序找到第k个结点就是结果。
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k){
        int index = 0; //计数器
        if(pRoot != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(pRoot.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = KthNode(pRoot.right,k);
            if(node != null)
                return node;
        }
        return null;
        }


        //中序非递归 栈
    TreeNode KthNode1(TreeNode pRoot, int k){
            int count = 0;
            if (count > k || pRoot == null)
                return null;
            TreeNode p = pRoot;
            Stack<TreeNode> LDRStack = new Stack<TreeNode>();
            TreeNode kthNode = null;
            while (p != null || !LDRStack.isEmpty()) {
                while (p != null) {
                    LDRStack.push(p);
                    p = p.left;
                }
                TreeNode node = LDRStack.pop();
                System.out.print(node.val + ",");
                count++;
                if (count == k) {
                    kthNode = node;
                }
                p = node.right;
            }
            return kthNode;
        }
}
