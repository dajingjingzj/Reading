package com.atzj.xiaoyi;

import java.util.Scanner;

/**
 * 类描述： dp
 * 最长公共子序列
 * @author zhoujing129
 */
public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine().toLowerCase();
            String s2 = sc.nextLine().toLowerCase();
            System.out.println (findLCS(s1,s1.length(),s2,s2.length()));
        }
    }

    public static int findLCS(String s1,int m,String s2, int n){
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                dp[i][j] = 0;
            }
        }
        for(int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
