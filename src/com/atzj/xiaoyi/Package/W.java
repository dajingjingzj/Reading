package com.atzj.xiaoyi.Package;

import java.util.Scanner;

/**
 * 类描述： 背包问题 每个物品无限次放
 * 有重量有价值 保证价值最大 背包容量有限
 * n中物品 重量w 价值v 背包容量M
 * @author zhoujing129
 */
public class W {
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

        /*int [][] dp = new int[n+1][m+1]; //前i件物品恰放入一个容量为v的背包可以获得的最大价值

        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<m; j++){
            dp[0][j] = 0;
        }

        for (int i=1; i<=n; i++){
            for (int j=0; j<=m; j++){
                for (int k=0; k <= m/w[i]; i++){ //m/w[i] 当前背包最多可放 k个 i 物品
                    if(j >= k * w[i]){
                        dp[i][j] = Math.max(dp[i-1][j-k*w[i]]+k*v[i],dp[i][j]);//因为这时放k个第i个物品，之后还可能继续放这个物体，所以应是F[i][j]
                    }else {
                        dp[i][j] = dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n][m]);*/

        //一维数组
        int[] f = new int[m+1];
        for(int i=0;i<f.length;i++){
            f[i] = 0;
        }
        for(int i=0;i<v.length;i++){
            for(int j=w[i];j<f.length;j++){
                f[j] = Math.max(f[j], f[j-w[i]]+v[i]);
            }
        }
        System.out.println(f[m]);

    }
}
