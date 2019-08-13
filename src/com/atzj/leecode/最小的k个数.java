package com.atzj.leecode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 类描述：
 * 堆是一种经过排序的完全二叉树，其中任一非终端节点的数据值均不大于（或不小于）其左孩子和右孩子节点的值。
 * 最大堆和最小堆是二叉堆的两种形式。
 * 最大堆：根结点的键值是所有堆结点键值中最大者。
 * 最小堆：根结点的键值是所有堆结点键值中最小者。
 *
 * @author zhoujing129
 */
public class 最小的k个数 {
    public static void main(String[] args) {
        int [] a = new int[]{4,5,1,6,2,7,3,8};

    }

    /**
     * 用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
     * java中的优先队列基于堆实现的
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        //不指定Comparator时默认为最小堆
        //使用默认的初始容量（11）创建一个 PriorityQueue，并根据其自然顺序对元素进行排序
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);//此优先级队列插入指定元素
            } else if (maxHeap.peek() > input[i]) { //获取但不移除此队列的头，若为空返回null
                Integer temp = maxHeap.poll(); //获取但移除此队列的头，若为空返回null
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }

}
