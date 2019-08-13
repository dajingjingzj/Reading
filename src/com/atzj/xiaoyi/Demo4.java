package com.atzj.xiaoyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 类描述：
 * 验证输入数列是否是等差数列
 * 先排序  Arrays.sort(arr); 再比较每一个前后项差是否相等；
 * @author zhoujing129
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int len = arr.length;
        if(len <= 2){
            System.out.println("Possible");
            return;
        }
        int d = arr[1] - arr[0];
        for (int i = 1; i < n; i++){
            int temp = arr[i+1] - arr[i];
            if(temp != d){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
