package com.atzj.leecode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int [] num = {2,4,6,7,8,3};
        int size = 3;
        System.out.println(maxInWindows(num,size));

    }

    /**
     *
     * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列
     * 原则：
     * 对新来的元素k，将其与双端队列中的元素相比较
     *  1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
     *  2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     *  队列的第一个元素是滑动窗口中的最大值
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size){

        ArrayList<Integer> result = new ArrayList<>(); //双端队列里保存的是下标
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return result;
        }

        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!list.isEmpty() && num[list.peekLast()] < num[i]) {
                list.pollLast(); //移除最后一个元素
            }
            list.addLast(i);
            //判断队首元素是否过期
            if (list.peekFirst() == i - size) { //返回队列第一个元素，但是不删除这个元素
                list.pollFirst(); //移除第一个元素
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[list.peekFirst()]);
            }
        }
        return result;
    }
}
