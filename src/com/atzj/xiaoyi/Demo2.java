package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 * 苹果堆
 * @author zhoujing129
 * @date 2019/7/31
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] appnums = new int[n];
        for (int i = 0; i < n; i++)
            appnums[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] count = new int[m];
        for (int i = 0; i < m; i++)
            count[i] = sc.nextInt();

        int[] leftsums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) { //累加各项和放至数组中
            sum += appnums[i];
            leftsums[i] = sum;
        }

        for (int i = 0; i < m; i++) {
            System.out.println(binSearch(leftsums, count[i]) + 1);
        }
    }

    /**
     * 二分查找
     * @param arr
     * @param i
     * @return
     */
    private static int binSearch(int[] arr, int i) {
        int mid = arr.length/2;
        if(i==arr[mid]){
            return mid;
        }
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            mid = (end-start)/2 + start;
            if(i < arr[mid] ) {
                end = mid - 1;
            }else if(i > arr[mid]){
                start = mid +1;
            }else
                return mid;
        }

        return start;
    }

}
