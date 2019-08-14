package com.atzj.leecode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 类描述：
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author zhoujing129
 */
public class 数据流中的中位数 {
    int count=0; //count用于控制小顶堆和大顶堆个数相差不超过1
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() { //默认小顶堆，重写compare为大顶堆
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    /**
     *
     * 思路： 顶堆默认为自然排序
     * 为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
     * 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
     * 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
     * @param num
     */
    public void Insert(Integer num) {
        count++;
        if((count & 1 )==0){ //判断偶数的高效写法
            if(! maxHeap.isEmpty() && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            maxHeap.offer(num);
        }else {
            if(! minHeap.isEmpty() & num > minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if(count == 0) {
            throw new RuntimeException("no available number!");
        }
        double result;
        if((count & 1)==1) {
            result = maxHeap.peek();
        } else {
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    }

    public void Insert1(Integer num) {
        if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian1() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

}
