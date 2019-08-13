package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class 牛牛背包 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] v = new int[n];
        int sum =0;
        for (int i=0; i<n; i++){
            v[i] = sc.nextInt();
            sum  += v[i];
        }
        if(sum <= w) {
            System.out.println(2 ^ n);
        }else {
            dfs(0,0,n,v,w);
            System.out.println(sum+1);
        }
    }

    private static void dfs(int sum, int cur, int n, int[] v, int w) {
        if (cur < n) {
            if (sum > w) {
                return;
            }
//            不添加这件零食
            dfs(sum, cur + 1, n, v, w);
            //            当前这种添加方式合理,添加这件零食
            if (sum + v[cur] <= w) {
                count++;
                dfs(sum + v[cur], cur + 1, n, v, w);
            }
        }
    }
}
