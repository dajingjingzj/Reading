package com.atzj.paixu;



/**
 * 类描述：
 * 选择排序 每次找出最小的元素
 * @author zhoujing129
 * @date 2019/7/23
 */
public class Xuanze {
    public static void main(String[] args) {
        int [] arr = {1,5,7,4,3};
        int [] b = choose(arr);
        for(int i=0; i<b.length; i++){
            System.out.println(b[i]);
        }
    }

    public static int [] choose(int[] arr) {
        int len = arr.length;
        if(len == 0)
            return arr;
        for (int j = 0; j < len; j++) {
            int minindex = j;
            //找出最小的元素
            for (int i = j; i < len; i++) {
                if (arr[i] < arr[minindex]) {//找到最小的数
                    minindex = i; //将最小元素的索引保存
                }
            }
            int t = arr[minindex];
            arr[minindex] = arr[j];
            arr[j] = t;
        }
        return arr;
    }
}