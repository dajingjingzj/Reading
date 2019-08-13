package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 * 打瞌睡； 先算出所有清醒时间分值； 再与叫醒时间内分值加上之前的 比较
 * @author zhoujing129
 * @date 2019/7/31
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] scores = new int[n];
        for (int i=0; i<n; i++){
            scores[i] = sc.nextInt();
        }

        int[] sleep = new int[n];
        for (int i = 0; i < n; i++) {
            sleep[i] = sc.nextInt();
        }

        int sum = 0;
        int max = 0;
        for (int i=0; i<n; i++){
            if(sleep[i]==1)
                sum += scores[i];
        }

        for (int i=0; i<n; i++){
            if(sleep[i]==0){
                int temp = sum;
                for (int j=i; j<Math.min(i+k,n); j++){
                    if(sleep[j]==0){
                        temp += scores[j];
;                    }
                }
                if(temp>max)
                    max = temp;
            }
        }
        System.out.println(max);
    }
}
