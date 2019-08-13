package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class Demo8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(max2(a,b,c));

    }

    public static int max1(int a, int b){
        return Math.max((a+b),a*b);
    }
    public static int max2(int a, int b, int c){
        int cc = max1(a,b)*c;
        int cs = max1(a,c)*b;
        int cd = max1(b,c)*a;
        int p =  Math.max(cc,cs);
        int q = Math.max(cc, cd);
        return Math.max(p,q);
    }
}
