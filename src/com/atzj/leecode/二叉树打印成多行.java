package com.atzj.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 二叉树打印成多行 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<TreeNode> list = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>(); // 队列LinkedList完成层序遍历，用end记录每层结点数目
        list.add(pRoot);
        int start=0,end=1;
        while (! list.isEmpty()){
            TreeNode node = list.remove();
            layerList.add(node.val);
            start++;
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            if(start == end){
                end = list.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        return result;
    }
}
