package com.atzj.demobingfa;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class Demo {
    public static void main(String[] args) {
       int [] arr = {11,13,15,17,19,21};
       int k = 19;
        binary(arr,k);

    }
    public static void binary(int [] arr, int k){
        int start = 0;
        int end = arr.length;
        System.out.println(select(arr,k,start,end));
    }

    public static int select(int [] arr, int k,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (end+start)/2;
        if(arr[mid] == k){
           return mid+1;
        }else if(arr[mid] > k){
           return select(arr,k,start,mid-1);
        }else if(arr[mid] <k){
           return select(arr,k,mid+1,end);
        }
        return -1;
    }
}
