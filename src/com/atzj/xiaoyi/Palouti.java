package com.atzj.xiaoyi;

/**
 * 类描述： 动态规划dp
 * 边界条件：DP[1]=1   DP[2]=2
 * @author zhoujing129
 */
public class Palouti {
    public static void main(String[] args) {
        System.out.println(DP(4));

        System.out.println(Dp(4));
    }

    //自顶向下  递归算法
    public static int DP(int n){
        int [] dp = new int[n+1];
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        dp[n] = DP(n-1) + DP(n-2); //递归
        return dp[n];

    }

    //自底向上 递推
    public static int Dp(int n){
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2]; //递推
        }
        return dp[n];
    }
}
