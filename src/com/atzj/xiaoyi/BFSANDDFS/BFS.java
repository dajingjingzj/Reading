package com.atzj.xiaoyi.BFSANDDFS;

/**
 * 类描述：
 * 广度
 * @author zhoujing129
 */
public class BFS {

    public Node first;
    public Node last;

    public static int run[] = new int[11];
    public static BFS head[] = new BFS[11];
    public final static int MAXSIZE = 12;
    static int[] queue = new int[MAXSIZE];
    static int front = -1;
    static int rear = -1;

    public static void enqueue(int value) {
        if(rear>=MAXSIZE) return;
        rear++;
        queue[rear] = value;
    }

    public static int dequeue() {
        if(front == rear) return -1;
        front++;
        return queue[front];
    }

    public static void bfs(int current) {
        Node tempnode;
        enqueue(current);
        run[current] = 1;
        System.out.print("[" + current + "]");
        while (front != rear) {
            current = dequeue();
            tempnode = head[current].first;
            while (tempnode != null) {
                if(run[tempnode.x] == 0) {
                    enqueue(tempnode.x);
                    run[tempnode.x] = 1;
                    System.out.print("[" + tempnode.x + "]");
                }
                tempnode = tempnode.next;
            }
        }
    }

    public boolean isEmpty() {
        return first == null;
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
