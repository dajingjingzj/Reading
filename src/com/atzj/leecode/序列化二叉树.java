package com.atzj.leecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 类描述：

 *
 * 算法思想：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
 *     依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
 *     另外，结点之间的数值用逗号隔开
 * @author zhoujing129
 */
public class 序列化二叉树 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //层序遍历
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while (! queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val+",");
            }else {
                sb.append("#"+",");
            }
        }
        if(sb.length() != 0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        TreeNode head = null;
        if(str == null || str.length() == 0){
            return head;
        }
        String [] nodes = str.split(",");
        TreeNode [] treeNodes = new TreeNode[nodes.length];
        for (int i=0; i<nodes.length; i++){
            if(! nodes[i].equals("#")){
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
            }
        }
        for (int i=0,j=1; j<treeNodes.length; i++){
            if(treeNodes[i] != null){
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }

    //前序遍历

    String Serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getSerializeString(root, sb);
        if(sb.length() != 0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
      void getSerializeString(TreeNode root, StringBuilder sb){
        if(root == null)
            sb.append("#,");
        else{
            sb.append(root.val + ",");
            getSerializeString(root.left, sb);
            getSerializeString(root.right, sb);
        }
    }
    TreeNode Deserialize1(String str) {
        if(str == null || str.length() == 0 || str.length() ==1)
            return null;
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for(int i=0; i<nodes.length; i++){
            if(!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNodes[0]);
        int i = 1;
        while(treeNodes[i] != null){
            stack.peek().left = treeNodes[i];
            stack.push(treeNodes[i++]);
        }
        while(!stack.isEmpty()){
            stack.pop().right = treeNodes[++i];
            if(treeNodes[i] != null){
                stack.push(treeNodes[i++]);
                while(treeNodes[i] != null){
                    stack.peek().left = treeNodes[i];
                    stack.push(treeNodes[i++]);
                }
            }
        }
        return treeNodes[0];
    }
}
