package com.atzj.xiaoyi.BFSANDDFS;

/**
 * 类描述：
 * 深度
 * @author zhoujing129
 */
public class DFS {
    public Node first;
    public Node last;

    public static int run[] = new int[11];
    public static DFS head[] = new DFS[11];

    public static void dfs(int current) {
        run[current] = 1;
        System.out.print("[" + current + "]");

        while (head[current].first != null) {
            if(run[head[current].first.x] == 0) { //如果顶点尚未遍历，就进行dfs递归
                dfs(head[current].first.x);
            }
            head[current].first = head[current].first.next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }
    public void print() {
        Node current = first;
        while(current != null) {
            System.out.print("[" + current.x + "]");
            current = current.next;
        }
        System.out.println();
    }
    public void insert(int x) {
        Node newNode = new Node(x);
        if(this.isEmpty()) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
    }
}
