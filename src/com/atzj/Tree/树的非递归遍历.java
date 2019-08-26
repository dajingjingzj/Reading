package com.atzj.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 树的非递归遍历 {
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
     * @return
     */
    public ArrayList<Integer> preOrder(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode root = stack.pop();
            list.add(root.val);
            if(node.right!= null){
                stack.push(node.right);
            }
            if(node.left!= null){
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * @param node
     * @return
     */
    public ArrayList<Integer> inOrder(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (p != null || ! stack.isEmpty() ){
            while (p!= null){
                stack.push(p);
                p = p.left;
            }
            if(! stack.isEmpty()){
                TreeNode treeroot = stack.pop();
                list.add(treeroot.val);
                p = treeroot.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p =root;
        TreeNode pre= root;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p= p.left;
            }
            if(!stack.isEmpty()){
                TreeNode treeroot = stack.peek().right;
                if(treeroot==null||treeroot==pre){
                    p= stack.pop();
                    list.add(p.val);
                    pre=p;
                    p=null;
                }
                else{
                    p=treeroot;
                }
            }
        }
        return list;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode treeroot = queue.poll();

            if(treeroot.left!=null){
                queue.offer(treeroot.left);
            }
            if(treeroot.right!=null){
                queue.offer(treeroot.right);
            }
            list.add(treeroot.val);
        }
        return list;
    }

}
