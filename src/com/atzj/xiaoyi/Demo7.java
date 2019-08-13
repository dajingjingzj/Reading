package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class Demo7 {
    public static void main(String[] args) {
        int [] arr ={1,4,33,2,1,4,5,9};
        int [] a = new int[9];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<9; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(a.length+"-----------");
      /*  for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }*/

        for (int i = 0; i < 9; i++){
            System.out.println(a[i]);
        }
    }
}
