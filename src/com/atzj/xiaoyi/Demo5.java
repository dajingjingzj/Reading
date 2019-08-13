package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt();
            int f = sc.nextInt();
            int d = sc.nextInt();
            int p = sc.nextInt();
            if(d/x <= f){
                System.out.println(d/x);
                return;
            }else {
                System.out.println((d - f*x)/(p+x)+f);
            }
        }
    }
}
