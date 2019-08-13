package com.atzj.paixu;

/**
 * 类描述：
 * 快速排序  基准对比 大的放右边小的放左边  递归 分而治之
 * @author zhoujing129
 * @date 2019/7/23
 */
public class Kuaisu {
    public static void main(String[] args) {
        int [] arr = {2,6,4,7,9,1};
        kua(arr,0,arr.length-1);
        for(int i=0 ; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void kua(int [] arr ,int low, int high){
        /*int tmp = kuaipai(arr,start,end);
        kuaipai(arr,start,tmp-1);
        kuaipai(arr,tmp+1, end);*/
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先从右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再从左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        kua(arr, low, j-1);
        //递归调用右半数组
        kua(arr, j+1, high);
    }

    public static int  kuaipai(int [] arr,int start, int end){
        //int pivot = (int) (start+Math.random()*(end - start +1));
        int pivot = arr[start];
        while (start < end ){
            if(arr[end] > pivot && start < end ){
                end--;
            }
            if(arr[start] < pivot  && start < end){
                start++;
            }
            int t = arr[end];
            arr[end] = arr[start];
            arr[start] = t;
        }
        arr[start] = pivot;
        return start;
    }
}
