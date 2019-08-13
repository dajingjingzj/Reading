package com.atzj.xiaoyi.Package;

import java.util.Scanner;

/**
 * 类描述： 背包问题 每个物品仅放一次
 * 有重量有价值 保证价值最大 背包容量有限
 * n中物品 重量w 价值v 背包容量M
 * @author zhoujing129
 */
public class WandV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int [] w = new int[n];
        int [] v = new int[n];

        for (int i=0; i<n; i++){
            w[i] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            v[i] = sc.nextInt();
        }
/*
        int [][] dp = new int[n+1][m+1]; //前i件物品恰放入一个容量为v的背包可以获得的最大价值

        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<m; j++){
            dp[0][j] = 0;
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<=m; j++){
                if(w[i] > j){
                    dp[i+1][j] = dp[i][j];
                }else {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j-w[i]] +v[i]);
                }
            }
        }
        System.out.println(dp[n][m]);*/

        //一维数组
        int[] f = new int[m+1];
        for(int i=0;i<f.length;i++){
            f[i] = 0;
        }
        for(int i=0;i<n;i++){
            for(int j=f.length-1;j>=w[i];j--){
                f[j] = Math.max(f[j], f[j-w[i]]+v[i]);
            }
        }
        System.out.println(f[m]);
    }
}
