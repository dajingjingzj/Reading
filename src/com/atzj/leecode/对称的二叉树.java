package com.atzj.leecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 类描述： 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author zhoujing129
 */
public class 对称的二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 递归
     *  思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     *  左子树的右子树和右子树的左子树相同即可，采用递归
     *  非递归也可，采用栈或队列存取各级子树根节点
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null)
            return true;
        return comRoot(pRoot.left,pRoot.right);

    }
    private boolean comRoot(TreeNode left, TreeNode right) {
        /*if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;*/
        if(left == null)
            return right==null;
        if(right == null)
            return false;
        return left.val == right.val //镜像的条件，左右节点值相等
                && comRoot(left.right,right.left)
                && comRoot(left.left,right.right);
    }

    /**
     * 非递归
     *  DFS使用stack来保存成对的节点
     *   1.出栈的时候也是成对成对的 ，
     *      1.若都为空，继续；
     *      2.一个为空，返回false;
     *      3.不为空，比较当前值，值不等，返回false；
     *   2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left
     * @param pRoot
     * @return
     */
    boolean isSymmetricalDFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }

    /**
     *  BFS使用Queue来保存成对的节点，代码和上面极其相似
     * * 1.出队的时候也是成对成对的
     * 1.若都为空，继续；
     * 2.一个为空，返回false;
     * 3.不为空，比较当前值，值不等，返回false；
     * * 2.确定入队顺序，每次入队都是成对成对的，如left.left， right.right ;left.rigth,right.left
     * @param pRoot
     * @return
     */
    boolean isSymmetricalBFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while(!s.isEmpty()) {
            TreeNode left= s.poll();//成对取出
            TreeNode right= s.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }
}
