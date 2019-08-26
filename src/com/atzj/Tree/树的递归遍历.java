package com.atzj.Tree;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 树的递归遍历 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 先序遍历
     * @param node
     */
    private void preOrder(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    private void inOrdre(TreeNode node){
        if(node == null)
            return;
        inOrdre(node.left);
        System.out.println(node.val);
        inOrdre(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    private void postOrdre(TreeNode node){
        if(node == null)
            return;
        inOrdre(node.left);
        inOrdre(node.right);
        System.out.println(node.val);
    }


}
